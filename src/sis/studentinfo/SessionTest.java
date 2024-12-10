package sis.studentinfo;

import junit.framework.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void testAverageGpaForPartTimeStudent(){
        session.enroll(createFullTimeStudent());

        Student partTimer1 = new Student("1");
        partTimer1.addGrade(Student.Grade.A);
        partTimer1.addGrade(Student.Grade.B);
        session.enroll(partTimer1);

        session.enroll(createFullTimeStudent());

        Student partTimer2 = new Student("2");
        partTimer2.addGrade(Student.Grade.B);
        session.enroll(partTimer2);

        assertEquals(3.25, session.averageGpaForPartTimeStudents(), 0.05);
    }
    public void testTableLabeledBreak(){
        List<List<String>> table = new ArrayList<>();

        List<String> row1 = new ArrayList<>();
        row1.add("5");
        row1.add("2");
        List<String> row2 = new ArrayList<>();
        row2.add("3");
        row2.add("4");

        table.add(row1);
        table.add(row2);

        assertTrue(found(table, "3"));
        assertFalse(found(table, "8"));
    }
    public void testIterate(){
        enrollStudents(session);
        List<Student> results = new ArrayList<>();
        for (Student student: session) {
            results.add(student);
        }

        assertEquals(session.getAllStudents(), results);
    }

    private void enrollStudents(Session session) {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }


    private boolean found(List<List<String>> table, String number) {
        boolean found = false;
        search: //served as a label for the outer loop.
        for (List<String> row: table) {
            for (String value: row){
                if (value.equals(number)){
                    found = true;
                    break search;
                }
            }
        }
        return found;
    }
    private Student createFullTimeStudent() {
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }
}

