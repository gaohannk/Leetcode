package leetcode;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1:
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 */
public class AddBoldTaginString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String str : dict) {
            int curIndex = s.indexOf(str);
            while (curIndex != -1) {
                for (int i = curIndex; i < curIndex + str.length(); i++) {
                    bold[i] = true;
                }
                curIndex = s.indexOf(str, curIndex + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (!bold[i]) {
                result.append(s.charAt(i++));
                continue;
            }

            int left = i;
            while (i < s.length() && bold[i]) {
                i++;
            }
            result.append("<b>").append(s, left, i).append("</b>");
        }
        return result.toString();
    }
}
