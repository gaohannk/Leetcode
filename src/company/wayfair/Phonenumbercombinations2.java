package company.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * map = {
 * 1 : [2, 3, 4, 7],
 * 2 : [1, 3, 5, 8],
 * 3 : [1, 2, 6, 9],
 * 4 : [1, 7, 5, 6],
 * 5 : [2, 8, 4, 6],
 * 6 : [3, 9, 4, 5],
 * 7 : [1, 4, 8, 9],
 * 8 : [2, 5, 7, 9],
 * 9 : [3, 6, 7, 8]
 * }
 */
public class Phonenumbercombinations2 {

    private static final int MAX_PHONE_LENGTH = 7;
    public static HashMap<Integer, LinkedList<Integer>> MAP;

    public static List<String> phoneCombinations(int start) {

        // Initial MAP
        List<String> res = new ArrayList<>();
        StringBuilder phone = new StringBuilder(MAX_PHONE_LENGTH);
        phone.append(start);
        helper(start, phone, res);
        return res;
    }

    private static void helper(int cur, StringBuilder phone, List<String> res) {
        for (int i = 0; i < MAP.get(cur).size(); i++) {
            int next = MAP.get(cur).get(i);
            phone.append(MAP.get(cur).get(i));
            helper(next, phone, res);
            phone.setLength(phone.length() - 1);
        }
    }
}
