package leetcode.d;

public class DayoftheWeek2 {
    private static final int DAY_OFFSET = 3; // Thursday of Jan 1st 1970
    private static final int YEAR_FROM = 1970;
    private static final int YEAR_TO = 2100;
    private static final int[] LEAPS = new int[YEAR_TO - YEAR_FROM + 1];
    private static final int[] MONTHS = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEKDAYS = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    static {
        for (int i = YEAR_FROM; i <= YEAR_TO; i++) {
            if (i % 100 == 0)
                LEAPS[i - YEAR_FROM] = (i % 400 == 0) ? 366 : 365;
            else if (i % 4 == 0)
                LEAPS[i - YEAR_FROM] = 366;
            else
                LEAPS[i - YEAR_FROM] = 365;
        }
        for (int i = 1; i < LEAPS.length; i++)
            LEAPS[i] += LEAPS[i - 1];
        for (int i = 1; i < MONTHS.length; i++)
            MONTHS[i] += MONTHS[i - 1];
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int days = DAY_OFFSET + LEAPS[year - YEAR_FROM - 1]; // previous full years
        days += MONTHS[month - 1]; // previous full months
        if (month > 2) // current leap year correction
            days += (LEAPS[year - YEAR_FROM] - LEAPS[year - YEAR_FROM - 1]) % 365;
        days += day; // previous days of months

        return WEEKDAYS[days % 7];
    }
}
