package sis.studentinfo;

import java.util.*;

public class Student{

    enum Grade {A, B, C, D, F}
    private GradingStrategy gradingStrategy = new RegularGradingStrategy();
    private final List<Grade> grades = new ArrayList<>();
    public static final String IN_STATE = "CO";
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private final String name;
    private int credits;
    private String state = "";

    public Student(String name){
        this.name = name;
        credits = 0;
    }
    public String getName(){ return this.name; }
    public void setState(String state) { this.state = state.toUpperCase(); }
    public boolean isFullTime() { return credits >= CREDITS_REQUIRED_FOR_FULL_TIME; }
    public int getCredits() { return credits; }
    public void addCredits(int credits) { this.credits += credits; }
    public void seGradingStrategy(GradingStrategy gradingStrategy) { this.gradingStrategy = gradingStrategy;}
    public boolean isInState() { return state.equals(Student.IN_STATE); }
    public void addGrade(Grade grade) { grades.add(grade); }

    public double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade: grades)
            total += gradingStrategy.getGradePointsFor(grade);
        return total / grades.size();
    }
}

