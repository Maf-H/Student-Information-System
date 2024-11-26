package sis.report;

import junit.framework.*;
import java.time.LocalDate;
import java.util.ArrayList;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEW_LINE;


public class CourseReportTest extends TestCase {
    public void testReport(){
        final LocalDate date = DateUtil.createDate(2024, 1, 8);
        CourseReport report = new CourseReport();

        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));
        assertEquals(
        "CZEC 200" + NEW_LINE +
                "CZEC 220" + NEW_LINE +
                "ENGL 101" + NEW_LINE +
                "ITAL 330" + NEW_LINE+
                "ITAL 410" + NEW_LINE,
            report.text());
    }
    public void testSortStringsInPlace(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        java.util.Collections.sort(list);
        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));
    }
    public void testSortStringsInNewList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortedList = new ArrayList<>(list);
        java.util.Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));

        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }
    public void testStringCompareTo(){
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
    }

}
