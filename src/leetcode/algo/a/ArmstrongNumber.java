package leetcode.algo.a;

public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        String s = Integer.toString(N);
        int k = s.length();
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += Math.pow(s.charAt(i) - '0', k);
        }
        return sum == N;
    }
}
