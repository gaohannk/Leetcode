package leetcode;

/**
 * Find the smallest prime palindrome greater than or equal to N.
 * <p>
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 * <p>
 * For example, 2,3,5,7,11 and 13 are primes.
 * <p>
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 * <p>
 * For example, 12321 is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: 7
 * Example 2:
 * <p>
 * Input: 8
 * Output: 11
 * Example 3:
 * <p>
 * Input: 13
 * Output: 101
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 * Our brute force works except when NN is 8 digits (as explained in Approach Framework when we established that all 8 digit palindromes are not prime), so we can skip all 8 digit numbers.

 Algorithm

 For each number, check whether it is a palindrome. If it is, check whether it is a prime. If the number is 8 digits, skip to the 9 digit numbers.
 */
/**We can prove as follow:

 11 % 11 = 0
 1111 % 11 = 0
 111111 % 11 = 0
 11111111 % 11 = 0

 So:
 1001 % 11 = (1111 - 11 * 10) % 11 = 0
 100001 % 11 = (111111 - 1111 * 10) % 11 = 0
 10000001 % 11 = (11111111 - 111111 * 10) % 11 = 0

 For any palindrome with even digits:
 abcddcba % 11
 = (a * 10000001 + b * 100001 * 10 + c * 1001 * 100 + d * 11 * 1000) % 11
 = 0

 All palindrome with even digits is multiple of 11.
 So among them, 11 is the only one prime
 if (8 <= N <= 11) return 11
 For other, we consider only palindrome with odd dights.
 **/
public class PrimePalindrome {
    public int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            if (N % d == 0)
                return false;
        }
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }

//    public int reverse(int N) {
//        StringBuilder num = new StringBuilder(String.valueOf(N));
//        return Integer.valueOf(num.reverse().toString());
//    }
}
