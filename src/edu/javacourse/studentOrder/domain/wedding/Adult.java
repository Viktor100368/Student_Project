package edu.javacourse.studentOrder.domain.wedding;

import edu.javacourse.studentOrder.domain.wedding.Address;
import edu.javacourse.studentOrder.domain.wedding.Person;

import java.time.LocalDate;

public class Adult extends Person {
    private String passwordSerial;
    private String passwordNumber;
    private LocalDate issueDate;
    private String issueDepartment;
    private String university;
    private String studentId;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Adult(String surName, String givenName, String patronymic, LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPasswordSerial() {
        return passwordSerial;
    }

    public void setPasswordSerial(String passwordSerial) {
        this.passwordSerial = passwordSerial;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }


}
