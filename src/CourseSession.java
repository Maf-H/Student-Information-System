import java.util.ArrayList;
import java.util.List;

public class CourseSession {
    private final String department;
    private final String number;
    private final List<Student> students = new ArrayList<>();
    private final byte credits;
    private final String lecturer;

    public CourseSession(String department, String number, byte credits, String lecturer) {
        this.department = department;
        this.number = number;
        this.credits = credits;
        this.lecturer = lecturer;
    }
    public String getDepartment(){ return department; }
    public String getNumber(){ return number; }
    public List<Student> getAllStudents() { return students; }
    public byte   getCredits(){ return credits; }
    public String getLecturer(){ return lecturer; }
    public String getDescription(){ return getDepartment() + " " + getNumber() + " " + getCredits() + " " + getLecturer();}
    public void enroll(Student student){ students.add(student); }
    public int getNumberOfStudents(){ return students.size(); }
}
