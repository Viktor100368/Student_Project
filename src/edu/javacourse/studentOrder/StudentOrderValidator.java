package edu.javacourse.studentOrder;

import edu.javacourse.studentOrder.domain.register.AnswerCityRegister;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;
import edu.javacourse.studentOrder.mail.MailSending;
import edu.javacourse.studentOrder.domain.*;
import edu.javacourse.studentOrder.validator.ChildrenValidator;
import edu.javacourse.studentOrder.validator.CityRegisterValidator;
import edu.javacourse.studentOrder.validator.StudentValidator;
import edu.javacourse.studentOrder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSending mailSending;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSending = new MailSending();
    }


    public static void main(String[] args) {
        StudentOrderValidator so = new StudentOrderValidator();
        so.checkAll();
    }

    public void checkAll() {
            List<StudentOrder> soList = readStudentOrders();
        for (StudentOrder s:soList) {
            System.out.println();
            checkOneOrder(s);
        }
    }
    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        return soList;
    }
    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding weddingAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }
    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterValidator.checkCityRegister(so);
    }
    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingValidator.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenValidator.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentValidator.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSending.sendMail(so);

    }
}
