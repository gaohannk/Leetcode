package leetcode;

public class PrimeArrangements2 {
    public int numPrimeArrangements(int n) {
        int c_prime = prime_count(n);

        long r = 1;
        for (int i = 2; i <= c_prime; ++i) {
            r = r * i;
            r %= 1000000007;
        }
        for (int i = 2; i <= n - c_prime; ++i) {
            r = r * i;
            r %= 1000000007;
        }

        return (int) r;
    }

    // find how many prime numbers in [1, n]
    int prime_count(int n) {
        if (n < 2) return 0;
        int count = 1;
        for (int i = 3; i <= n; ++i) {
            boolean is_prime = true;
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) ++count;
        }

        return count;
    }
}
