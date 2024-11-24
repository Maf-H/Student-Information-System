package sis.report;

import junit.framework.*;
import sis.studentinfo.*;
import static sis.report.RosterReporter.NEW_LINE;

public class RosterReporterTest extends TestCase {

    public void testRosterReport() {
        CourseSession mathSession = CourseSession.create(
                "MATH", "200",
                DateUtil.createDate(2024,1,8)
        );

        mathSession.enroll(new Student("Mesfin"));
        mathSession.enroll(new Student("Jane"));

        String rosterReport = new RosterReporter(mathSession).getReport();
        assertEquals(
            RosterReporter.ROSTER_REPORT_HEADER +
            "Mesfin" + NEW_LINE +
            "Jane" + NEW_LINE +
            RosterReporter.ROSTER_REPORT_FOOTER + "2" +
            NEW_LINE, rosterReport);
    }
}
