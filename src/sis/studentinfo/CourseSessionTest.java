package sis.studentinfo;

import junit.framework.TestCase;
import java.time.LocalDate;

public class CourseSessionTest extends TestCase {

    private CourseSession englishSession;
    private CourseSession mathSession;
    private LocalDate startDate;
    private static final int CREDITS = 3;

    public void setUp(){
        startDate = DateUtil.createDate(2024, 1, 8);
        englishSession =  createCourseSession( "ENGL", "101", startDate);
        mathSession = createCourseSession("MATH", "200", startDate);
    }
    public void testCreate() {
        assertEquals("ENGL", englishSession.getDepartment());
        assertEquals("101", englishSession.getNumber());
        assertEquals(0, englishSession.getNumberOfStudents());
        assertEquals(startDate, englishSession.getStartDate());
     }
    public void testCreateCourseSession(){
        String expectedEnglishSession = "ENGL";
        String englishCourseNumber = "101";
        assertEquals(expectedEnglishSession, englishSession.getDepartment());
        assertEquals(englishCourseNumber, englishSession.getNumber());
        assertEquals(0, englishSession.getNumberOfStudents());

        String expectedMathSession = "MATH";
        String mathCourseNumber = "200";
        assertEquals(expectedMathSession, mathSession.getDepartment());
        assertEquals(mathCourseNumber, mathSession.getNumber());
     }
    public void testEnrolledStudents(){
        Student firstStudent = new Student("Mesfin Haftu");
        mathSession.enroll(firstStudent);
        assertEquals(CREDITS, firstStudent.getCredits());
        assertEquals(1, mathSession.getNumberOfStudents());
        assertEquals(firstStudent, mathSession.get(0));

        Student secondStudent = new Student("Jane Doe");
        mathSession.enroll(secondStudent);
        assertEquals(CREDITS, secondStudent.getCredits());
        assertEquals(2, mathSession.getNumberOfStudents());
        assertEquals(secondStudent, mathSession.get(1));
    }
    public void testCourseDates(){
        LocalDate sixteenWeekOut = DateUtil.createDate(2024, 4, 26);
        assertEquals(sixteenWeekOut, englishSession.getEndDate());
    }
    public void testCount(){
        CourseSession.resetCount();
        createCourseSession("ENGL", "101", startDate);
        assertEquals(1, CourseSession.getCount());
        createCourseSession("MATH", "200", startDate);
        assertEquals(2, CourseSession.getCount());
    }
    private CourseSession createCourseSession(String department, String number, LocalDate startDate){
        CourseSession session = CourseSession.create(department, number, startDate);
        session.setNumberOfCredits(CourseSessionTest.CREDITS);
        return session;
    }
}