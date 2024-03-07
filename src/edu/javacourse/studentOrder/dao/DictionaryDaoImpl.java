package edu.javacourse.studentOrder.dao;

import edu.javacourse.studentOrder.config.Config;
import edu.javacourse.studentOrder.domain.Street;
import edu.javacourse.studentOrder.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
private static final  String GET_STREET = "select street_code ,street_name from jc_street " +
                    "where upper(street_name) like upper(?)";
    private Connection getConnect() throws SQLException {
        Connection conn = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD)
                );
        return conn;
    }

    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streets = new ArrayList<>();
        try (Connection con = getConnect();
             PreparedStatement stmt = con.prepareStatement(GET_STREET)) {
            stmt.setString(1,"%"+pattern+"%");
            ResultSet rs = stmt.executeQuery();
            //лучше использовать PreparedStatement вместо Statement, т.к.
            //упрощен синтаксис, и уменьшается вероятность SQL инъекций
//          Statement stmt = con.createStatement();
//            String sql =  "select street_code ,street_name from jc_street " +
//                    "where upper(street_name) like upper('%"+pattern+"%')";

         //   ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                streets.add(new Street(rs.getLong("street_code"), rs.getString("street_name")));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return streets;
    }


}
