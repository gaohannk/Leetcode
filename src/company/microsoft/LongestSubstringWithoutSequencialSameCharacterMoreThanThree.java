package company.microsoft;

/**
 * 给一个string， 例如 “aaabceddd”, 找到一个最长的substring，使得substring里面没有连续的相同三个字母。那这个答案就是7. “aabcedd”。 用sliding window 的思路解决。 O(N)
 */
public class LongestSubstringWithoutSequencialSameCharacterMoreThanThree {
    public static String findLongest(String input) {
        char[] chs = input.toCharArray();
        String res = "";
        int longest = 0;
        int left = 0, right = 0, n = chs.length;
        while (right < n) {
            // increase right pointer until there is three continuous letters that are same
            while (right + 2 < n && (chs[right] != chs[right + 1] ||
                    chs[right + 1] != chs[right + 2])) {
                right++;
            }
            // record the longest one if exist
            if (right + 2 - left > longest) {
                longest = right + 2 - left;
                res = input.substring(left, right + 2);
            }
            right++;
            left = right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLongest("aaabceddd"));
    }
}
