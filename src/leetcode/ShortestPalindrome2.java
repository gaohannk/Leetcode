package leetcode;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome2 {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;
        String revS = new StringBuilder(s).reverse().toString();
        char[] pattern = (s + "*"+ revS).toCharArray();
        int[] next = new int[pattern.length];
        next[0] = 0;
        int k;
        for(int i = 1; i < pattern.length; i++){
            k = next[i-1];
            while(k != 0 && pattern[i] != pattern[k]){
                k = next[k-1];
            }
            if(pattern[i] == pattern[k]) next[i] = k+1;
            else next[i] = 0;
        }
        int prefixLen = next[pattern.length-1];
        if(prefixLen >= s.length())
            return s;
        String prefix = new StringBuilder(s.substring(prefixLen)).reverse().toString();
        return prefix + s;
    }
}
