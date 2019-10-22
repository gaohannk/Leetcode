package leetcode.algo.p;

/**
 * Created by gaohan on 8/4/18.
 */
public class PrimePalindrome2 {

    public int primePalindrome2(int N) {
        if (8 <= N && N <= 11) {
            return 11;
        }
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y))
                return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) {
            return x == 2;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
