package leetcode.algo.p;

public class PerfectNumber2 {
    public boolean checkPerfectNumber(int num) {

        int sum = 0;
        if (num == 0) {
            return false;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum = sum + i;

            }
        }

        return sum == num;
    }
}
