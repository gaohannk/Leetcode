package leetcode;

import java.util.TreeMap;

/**
 * A password is considered strong if below conditions are all met:
 * <p>
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 * <p>
 * Insertion, deletion or replace of any one character are all considered as one change.
 */
public class StrongPasswordChecker {
    TreeMap<Integer, Integer> repeat = new TreeMap<Integer, Integer>();
    int missing = 0;
    int ops = 0;

    public int strongPasswordChecker(String s) {
        int count = 0;
        boolean lower = false, upper = false, digit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') lower = true;
            if (c >= 'A' && c <= 'Z') upper = true;
            if (c >= '0' && c <= '9') digit = true;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                if (count >= 3) increaseOne(count);
                count = 1;
            }
        }
        if (count >= 3) increaseOne(count);

        //Missing letter problem
        if (!lower) missing++;
        if (!upper) missing++;
        if (!digit) missing++;

        for (int i = 0; i < 6 - s.length(); i++)
            insert();
        for (int i = 0; i < s.length() - 20; i++)
            delete();
        for (int key : repeat.keySet())
            replace(key);
        if (missing > 0) ops += missing;
        return ops;
    }

    private void insert() {
        ops++;
        if (missing > 0) missing--;
        if (repeat.size() == 0) return;
        Integer key = repeat.firstKey();
        decreaseOne(key);
        if (key > 4) increaseOne(key - 2);
    }

    private void delete() {
        ops++;
        if (repeat.size() == 0) return;
        Integer key = repeat.firstKey();
        decreaseOne(key);
        if (key > 3) increaseOne(key - 1);
    }

    private void replace(Integer key) {
        int count = repeat.get(key) * (key / 3);
        if (missing > 0) missing -= count;
        ops += count;
    }

    private void increaseOne(int key) {
        if (!repeat.containsKey(key)) repeat.put(key, 0);
        repeat.put(key, repeat.get(key) + 1);
    }

    private void decreaseOne(int key) {
        if (repeat.containsKey(key)) {
            repeat.put(key, repeat.get(key) - 1);
            if (repeat.get(key) == 0) repeat.remove(key);
        }
    }
}
