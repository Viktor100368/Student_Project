package edu.javacourse.studentOrder.validator;

import edu.javacourse.studentOrder.domain.AnswerWedding;
import edu.javacourse.studentOrder.domain.wedding.StudentOrder;

public class WeddingValidator {
     public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding running ");
        AnswerWedding aw = new AnswerWedding();
        aw.success = false;
        return aw;
    }
}
