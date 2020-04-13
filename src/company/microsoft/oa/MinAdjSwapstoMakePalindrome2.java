package company.microsoft.oa;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
 *
 * Practice online: https://www.codechef.com/problems/ENCD12
 *
 * Example 1:
 *
 * Input: "mamad"
 * Output: 3
 * Example 2:
 *
 * Input: "asflkj"
 * Output: -1
 * Example 3:
 *
 * Input: "aabb"
 * Output: 2
 * Example 4:
 *
 * Input: "ntiin"
 * Output: 1
 * Explanation: swap 't' with 'i' => "nitin"
 */
public class MinAdjSwapstoMakePalindrome2 {
    private boolean isPalindrome(char[] s) {
        Set<Character> set = new HashSet<>();
        for (char c : s) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public int minswaps(String s) {
        char[] chars = s.toCharArray();
        int swapCount = 0;
        if (!isPalindrome(chars)) {
            return -1;
        }
        int i = 0, j = chars.length - 1;
        int k = j;
        while (i < j) {
            k = j;
            while (chars[i] != chars[k] && k > i)
                k--;
            if (chars[i] == chars[k] && i != k) {
                while (k < j) {
                    swap(chars, k, k + 1);
                    k++;
                    swapCount++;
                }
                i++;
                j--;
            } else {
                swap(chars, i, i + 1);
                swapCount++;
            }
        }
        return swapCount;
    }
}
