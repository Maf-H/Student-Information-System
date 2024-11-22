package sis.report;

import junit.framework.*;
import sis.studentinfo.*;

public class RosterReporterTest extends TestCase {

    public void testRosterReport() {
        CourseSession mathSession = new CourseSession(
                "MATH", "200",
                DateUtil.createDate(2024,1,8),
                (byte) 5, "Nebyu"
        );

        mathSession.enroll(new Student("Mesfin"));
        mathSession.enroll(new Student("Jane"));

        String rosterReport = new RosterReporter(mathSession).getReport();
        assertEquals(
            RosterReporter.ROSTER_REPORT_HEADER +
            "Mesfin" + RosterReporter.NEW_LINE +
            "Jane" + RosterReporter.NEW_LINE +
            RosterReporter.ROSTER_REPORT_FOOTER + "2" +
            RosterReporter.NEW_LINE, rosterReport);
    }
}
