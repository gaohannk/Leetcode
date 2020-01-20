package leetcode.algo.s;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        char[] arr = str1.toCharArray();
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], str2.charAt(i));
            } else if (map.get(arr[i]) != str2.charAt(i)) {
                // one character mapping to two character
                return false;
            }
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
}
