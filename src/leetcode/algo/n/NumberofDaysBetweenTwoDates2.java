package leetcode.algo.n;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NumberofDaysBetweenTwoDates2 {

    public int daysBetweenDates(String date1, String date2) {
        //24-May-2017, change this to your desired Start Date
        LocalDate dateBefore = LocalDate.parse(date1);
        //29-July-2017, change this to your desired End Date
        LocalDate dateAfter = LocalDate.parse(date2);
        return (int) Math.abs(ChronoUnit.DAYS.between(dateBefore, dateAfter));

    }
}
