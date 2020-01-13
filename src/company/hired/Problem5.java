package company.hired;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    public static long solution(String s) {
        // Type your solution here
        if (s == null || s.length() == 0)
            return -1L;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return (long) i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "who wants hot watermelon?";
        System.out.println(solution(s));
    }
}
