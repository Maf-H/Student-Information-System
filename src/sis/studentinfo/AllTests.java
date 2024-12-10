package sis.studentinfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentTest.class,
        CourseSessionTest.class,
        RosterReporterTest.class,
        DateUtilTest.class,
        BasicGradingStrategyTest.class,
        HonorsGradingStrategyTest.class,
        PerformanceTest.class
})
public class AllTests {
    // No need for additional methods; annotations handle suite setup.
}