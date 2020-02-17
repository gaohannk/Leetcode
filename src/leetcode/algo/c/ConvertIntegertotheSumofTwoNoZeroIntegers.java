package leetcode.algo.c;

public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int num1 = 1, num2 = n - 1;

        while (hasZeroInDigit(num1) || hasZeroInDigit(num2)) {
            num1++;
            num2--;
        }

        return new int[]{num1, num2};
    }

    private boolean hasZeroInDigit(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

}
