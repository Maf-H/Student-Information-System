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
}
