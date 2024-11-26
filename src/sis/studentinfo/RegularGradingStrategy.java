package sis.studentinfo;

import static sis.studentinfo.BasicGradingStrategy.getBasicGradeFor;

public class RegularGradingStrategy implements GradingStrategy{

    public int getGradePointsFor(Student.Grade grade) {
       return BasicGradingStrategy.getBasicGradeFor(grade);
    }
}
