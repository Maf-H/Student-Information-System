package sis.studentinfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Provides a representation of a single semester
 * session of a specific University course
 * @author mesfinhaftu
 */

public class CourseSession {
    private static int count = 0;
    private final String department;
    private final String number;
    private final List<Student> allStudents = new ArrayList<>();
    private final LocalDate startDate;
    private  int numberOfCredits;
    /**
     * Construct a course session starting on a specific date
     *
     * @param department the department of the course
     * @param number the course number
     * @param startDate the date which the course session starts
     */
    private CourseSession(String department, String number, LocalDate startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    private static void incrementCount() { ++count; }
    public static void resetCount() { count = 0; }
    public static int getCount(){ return count;}

    public static CourseSession create(String department, String number, LocalDate startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    public String  getDepartment(){ return department; }
    public String  getNumber(){ return number; }
    public Student get(int index){ return allStudents.get(index); }
    public void    enroll(Student student){
        student.addCredits(numberOfCredits);
        allStudents.add(student);
    }
    public List<Student> getAllStudents(){ return allStudents; }
    public int     getNumberOfStudents(){ return allStudents.size(); }
    public LocalDate getStartDate() { return startDate; }
    /**
     * @return LocalDate, the last date of the course session
     * */
    public LocalDate getEndDate() {
       final int sessionLengthInWeeks = 16;
       final int daysInWeek = 7;
       final int lastDaysOfSessionWeekFromFridayToMonday = 3;
       int numberOfDays = (sessionLengthInWeeks * daysInWeek) - lastDaysOfSessionWeekFromFridayToMonday;
       return startDate.plusDays(numberOfDays);
    }
    public void setNumberOfCredits(int numberOfCredits) { this.numberOfCredits = numberOfCredits; }
}
