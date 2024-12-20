package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {
    public int getGradePointsFor(Student.Grade grade) {
        int points = super.getGradePointsFor(grade); // overriding super class method
        if (points > 0)
            points += 1;
        return points;
    }
}
