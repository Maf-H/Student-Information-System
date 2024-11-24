package sis.studentinfo;

public class Student {

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

    public boolean isInState() {
        return state.equals(Student.IN_STATE);
    }
}

