package company.wayfair;

import java.util.HashMap;

public class RemoveBallon {
    public static char[] ch = {'B', 'A', 'L', 'O', 'N'};

    public static int solution(String input) {
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            //System.out.println(c);
            map.putIfAbsent(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        for (char c : ch) {
            if (c == 'B' || c == 'A' || c == 'N') {
                res = Math.min(res, map.getOrDefault(c, 0));
            } else {
                res = Math.min(res, map.getOrDefault(c, 0) / 2);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] inputs = {"BAONXXOLL", "BAOOLLNNOLOLGBAX", "QAWABAWONL", "LLL"};
        for (String input : inputs) {
            System.out.println(solution(input));
        }
    }
}
