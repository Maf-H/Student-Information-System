package sis.studentinfo;

import junit.framework.TestCase;

import java.time.LocalDate;

public class CourseSessionTest extends TestCase {

    private CourseSession englishSession;
    private CourseSession mathSession;
    private LocalDate startDate;

    public void setUp(){
        startDate = DateUtil.createDate(2024, 1, 8);
        englishSession =  new CourseSession("ENGL", "101", startDate, (byte) 3, "Prof. Smith");
        mathSession = new CourseSession("MATH", "200", startDate, (byte) 5, "Nebyu");
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
        assertNotNull(englishSession.getDescription());
        assertEquals(0, englishSession.getNumberOfStudents());

        String expectedMathSession = "MATH";
        String mathCourseNumber = "200";
        assertEquals(expectedMathSession, mathSession.getDepartment());
        assertEquals(mathCourseNumber, mathSession.getNumber());
        assertNotNull(mathSession.getDescription());
     }
    public void testEnrolledStudents(){
        Student firstStudent = new Student("Mesfin Haftu");
        mathSession.enroll(firstStudent);
        assertEquals(1, mathSession.getNumberOfStudents());
        assertEquals(firstStudent, mathSession.get(0));

        Student secondStudent = new Student("Jane Doe");
        mathSession.enroll(secondStudent);
        assertEquals(2, mathSession.getNumberOfStudents());
        assertEquals(secondStudent, mathSession.get(1));
    }
    public void testCourseDates(){
        LocalDate sixteenWeekOut = DateUtil.createDate(2024, 4, 26);
        assertEquals(sixteenWeekOut, englishSession.getEndDate());
    }
}