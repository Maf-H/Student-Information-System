package sis.studentinfo;

import java.time.LocalDate;
/**
 * This class Provides a representation of a single semester
 * session of a specific University course
 * @author mesfinhaftu
 */

public class CourseSession extends Session{
    private static int count = 0;

    public static CourseSession create(String department, String number, LocalDate startDate){
        return new CourseSession(department, number, startDate);
    }
    protected CourseSession(String department, String number, LocalDate startDate) {
        super(department, number, startDate);
        CourseSession.incrementCount();
    }

    private static void incrementCount() { ++count; }
    public static void resetCount() { count = 0; }
    public static int getCount(){ return count;}
    // implementation of abstract method
    protected int getSessionLength(){ return 16; }
}
