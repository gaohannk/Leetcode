package company.inceptio.phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings stringA and stringB, the task is to find the smallest substring in stringA containing all characters of stringB efficiently.
 * Examples:
 *
 * Input: string = “this is a fantastic fan”, target = “tfan”
 * Output: Minimum window is “fant”
 * Explanation: “fant” contains all the characters of target.
 */
// TODO
public class SubstringContainCharinTarget {
    public static String shortestSubstring(String string, String target) {
        if (target.length() > string.length()) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minRes = string.length();
        String retString = "";
        int left = 0, right = 0;
        System.out.println(map);

        Map<Character, Integer> cur = new HashMap<>();

        while (left < string.length() && right < string.length()) {


            while (right < string.length()) {
                char c = string.charAt(right);

                cur.put(c, cur.getOrDefault(c, 0) + 1);
                System.out.println(right + "right" + cur + "left" + left);
                System.out.println(string.substring(left, right + 1));

                if (checkMap(map, cur)) {
                    if (minRes > right - left + 1) {
                        minRes = right - left + 1;
                        retString = string.substring(left, right + 1);
                        System.out.println("return string:" + retString);
                    }
                    break;
                }
                right++;
            }
            System.out.println("here");
            System.out.println(cur);
            System.out.println(map);

            cur.put(string.charAt(left), cur.getOrDefault(string.charAt(left), 0) - 1);
            left++;
            while (left < string.length() && checkMap(map, cur)){
                System.out.println(string.charAt(left));
                cur.put(string.charAt(left), cur.getOrDefault(string.charAt(left), 0) - 1);
                left++;
            }

        }
        return retString;
    }

    private static boolean checkMap(Map<Character, Integer> map, Map<Character, Integer> cur) {
        System.out.println(cur);
        System.out.println(map);
        for (char c : map.keySet()) {
            if (map.get(c) > cur.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubstring("ccgcccdmccccccgddmmg", "cdmg"));
    }
}
