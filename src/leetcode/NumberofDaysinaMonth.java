package leetcode;

public class NumberofDaysinaMonth {
    public int numberOfDays(int Y, int M) {
        boolean isLeapYear = false;
        if ((Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0) {
            isLeapYear = true;
        }
        if (M <= 7) {
            if (M == 2)
                return isLeapYear ? 29 : 28;
            return (M % 2 == 0) ? 30 : 31;
        }
        return (M % 2 == 0) ? 31 : 30;
    }
}
