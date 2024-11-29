package sis.studentinfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Session implements Comparable<Session>{

    private final String department;
    private final String number;
    private final List<Student> students = new ArrayList<>();
    private final LocalDate startDate;
    private  int numberOfCredits;

    protected Session(String department, String number, LocalDate startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public void    setNumberOfCredits(int numberOfCredits) { this.numberOfCredits = numberOfCredits; }
    public String  getDepartment(){ return department; }
    public String  getNumber(){ return number; }
    public int     getNumberOfStudents(){ return students.size(); }
    public void    enroll(Student student){
        student.addCredits(numberOfCredits);
        students.add(student);
    }
    public Student get(int index){ return students.get(index); }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() {
        final int daysInWeek = 7;
        final int lastDaysOfSessionWeekFromFridayToMonday = 3;
        int numberOfDays = (getSessionLength() * daysInWeek) - lastDaysOfSessionWeekFromFridayToMonday;
        return getStartDate().plusDays(numberOfDays);
    }
    public List<Student> getAllStudents(){ return students; }

    @Override
    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare != 0) { return compare; }
        return this.getNumber().compareTo(that.getNumber());
    }
    protected abstract int getSessionLength(); // template method
}
