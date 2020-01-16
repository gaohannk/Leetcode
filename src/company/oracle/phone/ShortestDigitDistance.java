package company.oracle.phone;

public class ShortestDigitDistance {
    public int shortestDistance(int[] digits, int d1, int d2) {
        if (digits == null)
            return 0;
        int idx1 = -1, idx2 = -1;
        int diff = digits.length;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == d1)
                idx1 = i;
            else if (digits[i] == d2)
                idx2 = i;
            if (idx1 != -1 && idx2 != -1) {
                diff = Math.min(diff, Math.abs(idx1 - idx2));
            }
        }
        return diff;
    }
}
