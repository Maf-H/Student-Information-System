package sis.studentinfo;

import junit.framework.*;
import java.time.LocalDate;

public abstract class SessionTest extends TestCase {
    private Session session;
    private LocalDate startDate;
    public static final int CREDITS = 3;

    @Override
    public void setUp(){
        startDate = DateUtil.createDate(2024, 1, 8);
        session =  createSession( "ENGL", "101", startDate);
        session.setNumberOfCredits(CREDITS);
    }

    abstract protected Session createSession(String department, String number, LocalDate startDate);

    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }
    public void testEnrolledStudents(){
        Student student1 = new Student("Mesfin Haftu");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Jane Doe");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student2, session.get(1));
    }
    public void testComparable(){
        final LocalDate date = DateUtil.createDate(2024, 1, 8);
        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession("CMSC", "210", date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
    public void testSessionLength(){
        assertTrue(session.getSessionLength() > 0);
    }
}

