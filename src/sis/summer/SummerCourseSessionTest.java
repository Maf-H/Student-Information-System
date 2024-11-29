package sis.summer;

import java.time.LocalDate;
import sis.studentinfo.*;

public class SummerCourseSessionTest extends SessionTest {
    public void testEndDate(){
        LocalDate startDate = DateUtil.createDate(2024, 6, 10);
        Session session = createSession("ENGL", "200", startDate);
        LocalDate eightWeekOut = DateUtil.createDate(2024, 8, 2);
        assertEquals(eightWeekOut, session.getEndDate());
    }
    @Override
    protected Session createSession(String department, String number, LocalDate startDate) {
        return SummerCourseSession.create(department, number, startDate);
    }
}
