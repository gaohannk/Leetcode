package leetcode;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        for(int i=1;i<=str.length()/2;i++){
            if(str.length()%i==0) {
                int start = 0;
                boolean flag = true;
                while (start + 2 * i <= str.length()) {
                    if (!str.substring(start, start + i).equals(str.substring(start + i, start + 2 * i))) {
                        flag = false;
                        break;
                    }
                    start += i;
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }
}
