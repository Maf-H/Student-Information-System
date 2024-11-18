import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CourseSessionTest extends junit.framework.TestCase {
    public void testCreate() { CourseSession session = new CourseSession("ENGL", "101", (byte) 3, "Prof. Smith");
    assertEquals("ENGL", session.getDepartment());
    assertEquals("101", session.getNumber()); }

public void testCreateCourseSession(){
        String expectedEnglishSession = "ENGL";
        String englishCourseNumber = "101";
        CourseSession englishSession = new CourseSession("ENGL", "101", (byte) 3, "Werede");
        assertEquals(expectedEnglishSession, englishSession.getDepartment());
        assertEquals(englishCourseNumber, englishSession.getNumber());
        assertNotNull(englishSession.getDescription());
        assertEquals(0, englishSession.getNumberOfStudents());

        String expectedMathSession = "MATH";
        String mathCourseNumber = "200";
        CourseSession mathSession = new CourseSession("MATH", "200", (byte) 5, "Neba");
        assertEquals(expectedMathSession, mathSession.getDepartment());
        assertEquals(mathCourseNumber, mathSession.getNumber());
        assertNotNull(mathSession.getDescription());
    }
    public void testEnrolledStudents(){
        Student firstStudent = new Student("Mesfin Haftu");

        CourseSession mathSession = new CourseSession("MATH", "200", (byte) 5, "Neba");
        mathSession.enroll(firstStudent);
        assertEquals(1, mathSession.getNumberOfStudents());

        Student secondStudent = new Student("Jane Doe");
        mathSession.enroll(secondStudent);
        assertEquals(2, mathSession.getNumberOfStudents());

        assertEquals(firstStudent, mathSession.getAllStudents().get(0)); // or assertEquals(firstStudent, mathSession.getStudents().get(0).)
        assertEquals(secondStudent, mathSession.getAllStudents().get(1));
    }
}