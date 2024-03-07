package edu.javacourse.studentOrder.validator;

import edu.javacourse.studentOrder.domain.register.AnswerCityRegister;
import edu.javacourse.studentOrder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentOrder.domain.wedding.Child;
import edu.javacourse.studentOrder.domain.register.CityRegisterResponse;
import edu.javacourse.studentOrder.domain.wedding.Person;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;
import edu.javacourse.studentOrder.exception.CityRegisterException;
import edu.javacourse.studentOrder.exception.TransportException;
import edu.javacourse.studentOrder.validator.register.CityRegisterChecker;
import edu.javacourse.studentOrder.validator.register.FakeCityRegisterChecker;

import java.util.Iterator;

public class CityRegisterValidator {
//   public String hostName;
//    public String login;
//    public String password;
    private static final String IN_CODE = "NO GRN";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

           ans.addItem(checkPerson(so.getHusband()));
            ans.addItem(checkPerson(so.getWife()));
            for(Child ch: so.getChildren()){
              ans.addItem(checkPerson(ch));
            }
        return ans;
    }
    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityError error = null;
        AnswerCityRegisterItem.CityStatus status = null;
        try {
           CityRegisterResponse tmp = personChecker.checkPerson(person);
           status = (tmp.isExisting())? AnswerCityRegisterItem.CityStatus.YES:
                   AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(e.getCode(),e.getMessage());
        } catch (TransportException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE,e.getMessage());
        }catch (Exception e){
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE,e.getMessage());
        }
        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status,person,error);
        return null;
    }
}
