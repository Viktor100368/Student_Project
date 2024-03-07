package edu.javacourse.studentOrder.validator;

import edu.javacourse.studentOrder.domain.AnswerChildren;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;

public class ChildrenValidator {
   public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running ");
        AnswerChildren ach = new AnswerChildren();
        ach.success = true;
        return ach;
    }
}
