import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest{
    @Test
    public void testCreate(){
        final String expectedFirstStudentName = "Jane Doe";
        Student firstStudent = new Student("Jane Doe");
        assertEquals(expectedFirstStudentName, firstStudent.getName());

        final String expectedSecondStudentName = "Mesfin Haftu";
        Student SecondStudent = new Student("Mesfin Haftu");
        assertEquals(expectedSecondStudentName, SecondStudent.getName());
    }
}
