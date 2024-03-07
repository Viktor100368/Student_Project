package edu.javacourse.studentOrder.dao;

import edu.javacourse.studentOrder.domain.Street;
import edu.javacourse.studentOrder.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern)throws DaoException;
}
