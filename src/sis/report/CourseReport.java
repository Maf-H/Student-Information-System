package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEW_LINE;

public class CourseReport {
    private final List<CourseSession> sessions = new ArrayList<>();

    public void add(CourseSession session) { sessions.add(session); }
    public String text() {
        Collections.sort(sessions); // Ordering based on compareTo
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions){
            builder.append(session.getDepartment()).append(" ").append(session.getNumber()).append(NEW_LINE);
        }
        return builder.toString();
    }
}
