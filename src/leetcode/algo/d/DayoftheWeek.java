package leetcode.algo.d;

public class DayoftheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        int newyear = year - 1971; //get how many years after 1971
        int adddays = (newyear - 1) / 4; //get how many leap years, because 1972 is leap year, so acutally it is year-1972 then divided by 4.
        if (year == 1972 && month > 2)
            adddays += 1; //if the time if after 1972 feb, we need to add a leap day.
        if (month == 2 && day == 29)
            adddays -= 1; //if any year is leap year, and month is 2 day is 29, we nned to delete the automatic leap day.
        if (year > 1972)
            adddays += 1; //we need to add 1972 leap day.
        if (year == 2100)
            adddays--; //2100 is not leap year, so we need to delete one.


        int[] monthdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; //days passed in month feb count as 28
        String[] wk = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"}; /* 1/1/1971 is Friday, so Friday first */
        int alldays = newyear * 365 + adddays + monthdays[month - 1] + day; //all days equals[how many years after 1972 *365+leap days+days passed by past month+current month past days]
        int wkday = alldays % 7; //[divided by 7 to get a reminder]
        if (wkday == 0)
            wkday = 6;
        else
            wkday -= 1; //because its 0 based, so we need to minus one, because can not have -1 index, so we change to 6.
        return wk[wkday];
    }
}
