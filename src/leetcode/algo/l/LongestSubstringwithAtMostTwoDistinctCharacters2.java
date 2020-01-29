package leetcode.algo.l;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters2 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int masLen = 2;
        while (right < n) {
            // slidewindow contains less than 3 characters
            if (hashmap.size() < 3)
                hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            masLen = Math.max(masLen, right - left);
        }
        return masLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eeecccbbbb"));
    }
}
