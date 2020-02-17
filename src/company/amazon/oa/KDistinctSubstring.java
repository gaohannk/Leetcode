package company.amazon.oa;

import java.util.*;

public class KDistinctSubstring {
    public static List<String> solution(String str, int K) {
        Map<Character, Integer> map = new HashMap<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i < K - 1; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = K - 1; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if (map.keySet().size() == K) {
                System.out.println(str.substring(i - K + 1, i + 1));
                res.add(str.substring(i - K + 1, i + 1));
            }
            map.put(str.charAt(i - K + 1), map.get(str.charAt(i - K + 1)) - 1);
            if (map.get(str.charAt(i - K + 1)) == 0) {
                map.remove(str.charAt(i - K + 1));
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(solution("awaglknagawunagwkwagl", 4));
    }
}
