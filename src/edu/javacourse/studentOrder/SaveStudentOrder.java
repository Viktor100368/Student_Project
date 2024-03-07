package edu.javacourse.studentOrder;


import edu.javacourse.studentOrder.dao.DictionaryDao;
import edu.javacourse.studentOrder.dao.DictionaryDaoImpl;
import edu.javacourse.studentOrder.domain.Street;
import edu.javacourse.studentOrder.domain.wedding.Address;
import edu.javacourse.studentOrder.domain.wedding.Adult;
import edu.javacourse.studentOrder.domain.wedding.Child;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args)throws Exception {
    List<Street> d =new DictionaryDaoImpl().findStreets("con");
    for(Street s:d){
        System.out.println(s.getStreetName());
    }

//        StudentOrder so = new StudentOrder();
//        buildStudentOrder();
//        //long ans = saveStudentOrder(so);
//        long ans = runningAll(so);
//        System.out.println("saveStudentOrder() returning "+ans);

    }
    static long runningAll(StudentOrder s){
        sheduleStudentOrder();
        financeStudentOrder();
        return saveStudentOrder(s);
    }
    static void sheduleStudentOrder(){
        System.out.println("SheduleStudentOrder is running");
    }
    static void financeStudentOrder(){
        System.out.println("FinanceStudentOrder is running");
    }
    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 123;
        System.out.println("saveStudentOrder ");
        return answer;
    }
    static StudentOrder buildStudentOrder(long id){
        Street street = new Street(1,"First street");
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId(""+(123456000 + id));
        so.setMarriageDate(LocalDate.of(2016,7,4));
        so.setMarriageOffice("Отдел ЗАГС");
        Address address = new Address("195000",street,"12","","142");
        //husband
        Adult husband = new Adult("Петров","Виктор","Сергеевич",LocalDate.of(1997,8,24));
        husband.setPasswordSerial(""+(1000+id));
        husband.setPasswordNumber(""+(100000+id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        husband.setIssueDepartment("Отдел милиции №" + id);
        husband.setStudentId(""+(100000+id));
        husband.setAddress(address);
        //wife
        Adult wife = new Adult("Петрова","Вероника","Алексеевна",LocalDate.of(1998,6,29));
        wife.setPasswordSerial(""+(2000+id));
        wife.setPasswordNumber(""+(200000+id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        wife.setIssueDepartment("Отдел милиции № "+id);
        wife.setStudentId(""+(200000+id));
        wife.setAddress(address);
        //child
        Child child1 = new Child("Птерова","Ирина","Викторовна",LocalDate.of(2018,6,29));
        child1.setCertificateSerial(""+(3000+id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("Отдел ЗАГС № "+id);
        child1.setAddress(address);
        //child
        Child child2 = new Child("Птеров","Евгений","Викторович",LocalDate.of(2018,6,29));
        child2.setCertificateSerial(""+(4000+id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        child2.setIssueDepartment("Отдел ЗАГС № "+id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
    }
}
