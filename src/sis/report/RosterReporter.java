package sis.report;

import sis.studentinfo.*;

import static sis.report.ReportConstant.NEW_LINE;

/**
 * Reports about students enrolled in current session.
 */
public class RosterReporter {

    public static final String  ROSTER_REPORT_HEADER = "Enrolled Student names" + NEW_LINE + "----------------------" + NEW_LINE;
    public static final String ROSTER_REPORT_FOOTER = "-----------------------\nTotal Students = ";
    private final CourseSession session;

    public RosterReporter(CourseSession session) {
        this.session = session;
    }
    public String getReport() {

        StringBuilder buffer = new StringBuilder();
        writeHeader(buffer);
        writeBody(buffer);
        writeFooter(buffer);
        return buffer.toString();
    }
    public void writeHeader(StringBuilder buffer){ buffer.append(ROSTER_REPORT_HEADER); }
    public void writeBody(StringBuilder buffer){
        for(Student student : session.getAllStudents()){
            buffer.append(student.getName());
            buffer.append(NEW_LINE);
        }
    }
    public void writeFooter(StringBuilder buffer){
        buffer.append(ROSTER_REPORT_FOOTER);
        buffer.append(session.getNumberOfStudents());
        buffer.append(NEW_LINE);
    }
}
