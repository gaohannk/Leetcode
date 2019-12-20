package leetcode.algo.n;

public class NumberComplement {
    public int findComplement(int x) {
        int mask = 1;
        while (mask > 0 && mask <= x) {
            x = x ^ mask;
            mask = mask << 1;
        }
        return x;
    }
}
