package sis.studentinfo;

import java.util.*;

public class Student{

    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
        private final int points;

        Grade(int points){
            this.points = points;
        }

        int getPoints(){ return points; }
    }
    private String firstName = "";
    private String middleName = "";
    private String lastName;

    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private final List<Grade> grades = new ArrayList<>();
    public static final String IN_STATE = "CO";
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private final String name;
    private int credits;
    private String state = "";
    private final List<Integer> charges = new ArrayList<>();
    public Student(String fullName) {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        setName(nameParts);
    }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public void   addCharge(int charge) { charges.add(charge); }
    public int    totalCharges() {
        int total = 0;
        for (int charge: charges){
            total += charge;
        }
        return total;
    }
    private void  setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) { this.firstName = name; }
        else {
                this.middleName = name;
                this.firstName = nameParts.removeLast();
            }
        }
    private String removeLast(List<String> list){
        if (list.isEmpty()){ return ""; }
        return list.removeLast();
    }
    private List<String> tokenize(String fullName) {
        List<String> result = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int index = 0;
        while (index < fullName.length()) {
            char character = fullName.charAt(index);
            if (character != ' ') { word.append(character); }
            else
                if (!word.isEmpty()){
                    result.add(word.toString());
                    word = new StringBuilder();
                }
            index++;
        }
        if (!word.isEmpty() ){ result.add(word.toString()); }
        return result;
    }
    private List<String> split(String fullName) {
        List <String> results = new ArrayList<>();
        Collections.addAll(results, fullName.split(" "));
        return results;
    }

    public String  getName(){ return this.name; }
    public void    setState(String state) { this.state = state.toUpperCase(); }
    public boolean isFullTime() { return credits >= CREDITS_REQUIRED_FOR_FULL_TIME; }
    public int     getCredits() { return credits; }
    public void    addCredits(int credits) { this.credits += credits; }
    public void    setGradingStrategy(GradingStrategy gradingStrategy) { this.gradingStrategy = gradingStrategy;}
    public boolean isInState() { return state.equals(Student.IN_STATE); }
    public void    addGrade(Grade grade) { grades.add(grade); }
    public double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade: grades)
            total += gradingStrategy.getGradePointsFor(grade);
        return total / grades.size();
    }
}

