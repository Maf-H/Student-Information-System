package sis.studentinfo;

import java.time.LocalDate;

public class DateUtil {
    public static LocalDate createDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
