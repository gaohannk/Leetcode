package leetcode;

/**
 * Let me try to prove why it safely move from i to i + k + 1. For example, for "cabcabx" the matching pattern is 'cab', at 'x' two candidates are mismatching. since 'x' > 'c',
 * we need move i, that's true we can just move to i + 1. However, as long as 'cab' is matching pattern. both 'a' and 'b' have been visited by j. so we can safely move to i + k + 1.
 * In other words, now j becomes i, i becomes to j. why do you want to go back a visited index? the idea is a little similar with KMP.
 */
public class LastSubstringinLexicographicalOrder {
    public String lastSubstring(String s) {
        int n = s.length();
        //k is the len when we have two candidates
        //i is the first candidate start position, j is the second one (can not be candidate)
        int i = 0, j = 1, k = 0;
        while (i < n && j < n && k < n) {
            if (i + k >= n || j + k >= n) {
                break;
            }
            // they have same start point, then increase the length
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            } else {
                // now two candidates are different, then which one is larger
                if (s.charAt(i + k) < s.charAt(j + k)) {
                    i = i + k + 1; // j becomes the candidate, i need move forward
                } else {
                    j = j + k + 1; // i becomes the candidate
                }
                if (i == j) {
                    j++; // protetional i, j stay at the same position, j move forward(i also can move)
                }
                k = 0; //reset the len
            }
        }
        int l = Math.min(i, j);
        return s.substring(l);
    }
}
