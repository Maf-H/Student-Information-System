package sis.studentinfo;

import java.time.LocalDate;

public class CourseSessionTest extends SessionTest {
    private LocalDate startDate;

    public void testCourseDates(){
        startDate = DateUtil.createDate(2024, 1, 8);
        Session session = createSession("ENGL", "200", startDate);
        LocalDate sixteenWeekOut = DateUtil.createDate(2024, 4, 26);
        assertEquals(sixteenWeekOut, session.getEndDate());
    }
    public void testCount(){
        CourseSession.resetCount();
        createSession("", "", startDate);
        assertEquals(1, CourseSession.getCount());
        createSession("", "", startDate);
        assertEquals(2, CourseSession.getCount());
    }
    @Override
    protected Session createSession(String department, String number, LocalDate startDate) {
        return CourseSession.create(department, number, startDate);
    }

}