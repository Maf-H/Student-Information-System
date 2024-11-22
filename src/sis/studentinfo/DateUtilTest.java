package sis.studentinfo;

import junit.framework.TestCase;
import java.time.LocalDate;

public class DateUtilTest extends TestCase {
    public void testCreateDate(){
        LocalDate date = DateUtil.createDate(2024, 1, 1);
        assertEquals(2024, date.getYear());
        assertEquals(1, date.getMonthValue());
        assertEquals(1, date.getDayOfMonth());
    }
}
