package leetcode;

import java.util.HashMap;

/**
 * Given a non-empty string, encode the string such that its encoded length is the shortest.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * <p>
 * Note:
 * <p>
 * k will be a positive integer and encoded string will not be empty or have extra space.
 * You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
 * If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.
 * Example 1:
 * <p>
 * Input: "aaa"
 * Output: "aaa"
 * Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
 * Example 2:
 * <p>
 * Input: "aaaaa"
 * Output: "5[a]"
 * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 * Example 3:
 * <p>
 * Input: "aaaaaaaaaa"
 * Output: "10[a]"
 * Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
 * Example 4:
 * <p>
 * Input: "aabcaabcd"
 * Output: "2[aabc]d"
 * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 * Example 5:
 * <p>
 * Input: "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
 */
public class EncodeStringwithShortestLength {
    static HashMap<String, String> map = new HashMap<>();

    public static String encode(String s) {
        String res = "";
        if (s.length() <= 1)
            return s;
        if (map.containsKey(s))
            return map.get(s);
        res = s;
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            String encode = solve(left) + encode(right);
            System.out.println("endcode:" + encode);
            if (encode.length() < s.length())
                res = encode;
        }
        map.put(s, res);
        return res;
    }

    private static String solve(String str) {
        String res = str;
        for (int i = 1; i <= str.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            if (str.length() % i == 0) {
                int times = str.length() / i;
                while (times-- > 0) {
                    sb.append(str.substring(0, i));
                }
                String encode = "";
                if (sb.toString().equals(str)) {
                    encode = str.length() / i + "[" + encode(str.substring(0, i)) + "]";
                    System.out.println(encode);
                    if (encode.length() < res.length()) {
                        res = encode;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcdcdcdabcdcdcdxyxyxyxy";
        System.out.println("encode string: " + encode(str));
    }
}
