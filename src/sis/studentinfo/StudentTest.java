package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    public void testCreate(){
        final String expectedFirstStudentName = "Jane Doe";
        Student firstStudent = new Student("Jane Doe");
        assertEquals(expectedFirstStudentName, firstStudent.getName());

        final String expectedSecondStudentName = "Mesfin Haftu";
        Student SecondStudent = new Student("Mesfin Haftu");
        assertEquals(expectedSecondStudentName, SecondStudent.getName());
    }
    public void testStudentStatus(){
        Student student = new Student("Menilik");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue("Not enough credits for FT status", student.isFullTime());
    }
    public void testInState(){
        Student student = new Student("Menilik");
        assertFalse(student.isInState());

        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());

        student.setState("MD");
        assertFalse(student.isInState());
    }
}
