package leetcode;

import java.util.ArrayList;
import java.util.Collections;

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
public class StrongPasswordChecker2 {
    public int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) {
            return 6;
        }
        boolean lower = false, upper = false, digit = false;
        int distance = 0, len = s.length();

        ArrayList<Integer> repeating = new ArrayList<>();
        char prev = '\0';
        int count = 0;
        for (char c : s.toCharArray()) {
            lower |= c >= 'a' && c <= 'z';
            upper |= c >= 'A' && c <= 'Z';
            digit |= c >= '0' && c <= '9';
            if (c == prev) {
                count++;
            } else {
                if (count >= 3) {
                    repeating.add(count);
                }
                count = 1;
                prev = c;
            }
        }
        if (count >= 3) {
            repeating.add(count);
        }
        int required = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);
        int patch = 0;
        Collections.sort(repeating);
        int i = 0;
        while (i < repeating.size()) {
            int c = repeating.get(i);
            if (len > 20) {
                int delta = Math.min(len - 20, c - 2);
                c -= delta;
                len -= delta;
                distance += delta;
            }
            if (len <= 20 && len >= 6) {
                distance += c / 3;
                patch += c / 3;
            } else if (len < 6) {
                patch += 1 + len - 6;
                distance += patch;
                len = 6;
            }
            i++;
        }
        if (len < 6) {
            distance += 6 - len;
            patch += 6 - len;
        } else if (len > 20) {
            distance += len - 20;
        }
        required -= patch;
        return distance + Math.max(required, 0);
    }
}
