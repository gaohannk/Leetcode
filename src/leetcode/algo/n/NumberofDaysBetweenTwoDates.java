package leetcode.algo.n;

public class NumberofDaysBetweenTwoDates {

    final static int[] monthlyDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDaysFromDate(date2) - getDaysFromDate(date1));
    }

    public int getDaysFromDate(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int res = 0;
        for (int i = 1971; i < year; i++) {
            res += 365;
            //Adding an extra day for all the leap years
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                res++;
        }

        for (int i = 1; i < month; i++) {
            res += monthlyDays[i];
            //Adding an extra day if the current year is a leap year
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))
                res++;
        }
        return res + day;
    }
}
