package edu.javacourse.studentOrder.validator.register;

import edu.javacourse.studentOrder.domain.register.CityRegisterResponse;
import edu.javacourse.studentOrder.domain.wedding.Person;
import edu.javacourse.studentOrder.exception.CityRegisterException;
import edu.javacourse.studentOrder.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
