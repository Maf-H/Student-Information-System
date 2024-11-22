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
    private final String department;
    private final String number;
    private final List<Student> allStudents = new ArrayList<>();
    private final LocalDate startDate;
    private final byte creditHours;
    private final String lecturer;
    /**
     * Construct a course session starting on a specific date
     *
     * @param department the department of the course
     * @param number the course number
     * @param startDate the date which the course session starts
     * @param creditHours the number of credits of the course
     * @param lecturer the lecturer of the course
     */
    public CourseSession(String department, String number, LocalDate startDate, byte creditHours, String lecturer) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
        this.creditHours = creditHours;
        this.lecturer = lecturer;
    }

    public String  getDepartment(){ return department; }
    public String  getNumber(){ return number; }
    public Student get(int index){ return allStudents.get(index); }
    public byte    getCreditHours(){ return creditHours; }
    public String  getLecturer(){ return lecturer; }
    public String  getDescription(){ return getDepartment() + " " + getNumber() + " " + getCreditHours() + " " + getLecturer();}
    public void    enroll(Student student){ allStudents.add(student); }
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
}
