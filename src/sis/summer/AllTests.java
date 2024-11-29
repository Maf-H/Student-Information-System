package sis.summer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.RosterReporterTest;
import sis.studentinfo.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SummerCourseSessionTest.class,

})
public class AllTests {
    // No need for additional methods; annotations handle suite setup.
}
