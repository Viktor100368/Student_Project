package edu.javacourse.studentOrder.validator.register;

import edu.javacourse.studentOrder.domain.wedding.Adult;
import edu.javacourse.studentOrder.domain.wedding.Child;
import edu.javacourse.studentOrder.domain.register.CityRegisterResponse;
import edu.javacourse.studentOrder.domain.wedding.Person;
import edu.javacourse.studentOrder.exception.CityRegisterException;
import edu.javacourse.studentOrder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String GOOD_3 = "3000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String BAD_3 = "3001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_3 = "3002";
    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";



    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult) {
            Adult t = (Adult) person;

                if (t.getPasswordSerial().equals(GOOD_1) || t.getPasswordSerial().equals(GOOD_2)) {
                    res.setExisting(true);
                    res.setTemporal(false);
                }
                if (t.getPasswordSerial().equals(BAD_1) || t.getPasswordSerial().equals(BAD_2)) {
                    res.setExisting(false);
                }
                if (t.getPasswordSerial().equals(ERROR_1) || t.getPasswordSerial().equals(ERROR_2)
                ) {
                    CityRegisterException ex = new CityRegisterException("1","GRN ERROR" + t.getPasswordSerial());
                    throw ex;
                } if (t.getPasswordSerial().equals(ERROR_T_1) || t.getPasswordSerial().equals(ERROR_T_2)
            ) {
                TransportException ex = new TransportException("ERROR Transport" + t.getPasswordSerial());
                throw ex;
            }
        }
        if(person instanceof Child){
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);
        return res;

    }
}
