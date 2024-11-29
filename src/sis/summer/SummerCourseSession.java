package sis.summer;

import sis.studentinfo.Session;
import java.time.LocalDate;

public class SummerCourseSession extends Session {
    /**
     * Construct a summer course session starting on a specific date
     *
     * @param department the department of the course
     * @param number     the course number
     * @param startDate  the date which the course session starts
     */
    public static Session create(String department, String number, LocalDate startDate) {
        return new SummerCourseSession(department, number, startDate);
    }
    public SummerCourseSession(String department, String number, LocalDate startDate) {
        super(department, number, startDate);
    }
    @Override
    protected int getSessionLength(){ return 8; } // Overrided template method

}
