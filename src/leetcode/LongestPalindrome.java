package leetcode;

import java.util.HashMap;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int sum=0;
        boolean flag=false;
        for(char c: map.keySet()){
            if(map.get(c)%2==0){
                sum+=map.get(c );
            }else{
                flag=true;
                sum+=map.get(c)-1;
            }
        }
        sum+=flag==true?1:0;
        return sum;
    }
}
