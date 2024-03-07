package edu.javacourse.studentOrder.validator;

import edu.javacourse.studentOrder.domain.AnswerStudent;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются: ");
        AnswerStudent ast = new AnswerStudent();
        ast.success = true;
        return ast;
    }
}
