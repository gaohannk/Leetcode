package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 722
 */

/**
 * Time Complexity: O(S)O(S), where SS is the total length of the source code.
 * <p>
 * Space Complexity: O(S)O(S), the space used by recording the source code into ans.
 */
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new LinkedList<>();
        boolean isComment = false;
        StringBuilder sb = null;
        for (String line : source) {
            char[] chars = line.toCharArray();
            if (!isComment) {
                sb = new StringBuilder();
            }
            for (int i = 0; i < chars.length; i++) {
                if (!isComment && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                    isComment = true;
                    i++;
                } else if (isComment && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                    isComment = false;
                    i++;
                } else if (!isComment && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!isComment) {
                    sb.append(chars[i]);
                }
            }
            if (!isComment && sb.length() != 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
