package leetcode.algo.s;

public class SumofDigitsintheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int each : A) {
            min = Math.min(min, each);
        }
        int sum = 0;
        for (char c : String.valueOf(min).toCharArray()) {
            sum += Integer.valueOf(c);
        }
        /*
        while(min!=0) {
            sum += min%10;
            min/=10;
        }
         */
        return sum % 2 == 0 ? 1 : 0;
    }
}
