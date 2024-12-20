package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private static final double GRADE_TOLERANCE = 0.05;

    public void testCreate(){
        final String expectedFirstStudentName = "Jane Doe";
        Student firstStudent = new Student("Jane Doe");
        assertEquals(expectedFirstStudentName, firstStudent.getName());
        assertEquals("Jane", firstStudent.getFirstName());
        assertEquals("Doe", firstStudent.getLastName());
        assertEquals("", firstStudent.getMiddleName());

        final String expectedSecondStudentName = "Mesfin";
        Student secondStudent = new Student("Mesfin");
        assertEquals(expectedSecondStudentName, secondStudent.getName());
        assertEquals("", secondStudent.getFirstName());
        assertEquals("Mesfin", secondStudent.getLastName());
        assertEquals("", secondStudent.getMiddleName());

        final String expectedThirdStudentName = "Robert Cecil Martin";
        Student thirdStudent = new Student("Robert Cecil Martin");
        assertEquals(expectedThirdStudentName, thirdStudent.getName());
        assertEquals("Robert", thirdStudent.getFirstName());
        assertEquals("Cecil", thirdStudent.getMiddleName());
        assertEquals("Martin", thirdStudent.getLastName());
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
    public void testCalculateGpa(){
        Student student = new Student("a");
        assertGpa(student, 0.0);

        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);

        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);

        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);

        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);

        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }
    public void testCalculateHonorsStudentGpa(){
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
    }
    public void testCharges(){
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(200);
        student.addCharge(399);

        assertEquals(1099, student.totalCharges());
    }
    private Student createHonorsStudent(Student.Grade grade) {
       Student student = createHonorsStudent();
       student.addGrade(grade);
       return student;
    }
    private Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }
    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }
}
