package leetcode;

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
/*This solution scans the password string twice.
First pass: check lacks of lower/upper/digit char.
Second pass: deals with repeating characters case based on the current length of the character.
*/
public class StrongPasswordChecker3 {
    public int strongPasswordChecker(String s) {
        if (s.length() <= 3)
            return 6 - s.length();

        //Initialize the states, including current ending character(end), existence of lowercase letter(lower), uppercase letter(upper), digit(digit) and number of replicates for ending character(end_rep)
        char end = s.charAt(0);
        boolean upper = end >= 'A' && end <= 'Z', lower = end >= 'a' && end <= 'z', digit = end >= '0' && end <= '9';

        //Also initialize the number of modification for repeated characters, total number needed for eliminate all consequnce 3 same character by replacement(change), and potential maximun operation of deleting characters(delete). Note delete[0] means maximum number of reduce 1 replacement operation by 1 deletion operation, delete[1] means maximun number of reduce 1 replacement by 2 deletion operation, delete[2] is no use here.
        int end_rep = 1, change = 0;
        int[] delete = new int[3];

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == end) ++end_rep;
            else {
                change += end_rep / 3;
                if (end_rep / 3 > 0)
                    ++delete[end_rep % 3];
                //updating the states
                end = s.charAt(i);
                upper = upper || end >= 'A' && end <= 'Z';
                lower = lower || end >= 'a' && end <= 'z';
                digit = digit || end >= '0' && end <= '9';
                end_rep = 1;
            }
        }
        change += end_rep / 3;
        if (end_rep / 3 > 0)
            ++delete[end_rep % 3];

        //The number of replacement needed for missing of specific character(lower/upper/digit)
        int check_req = (upper ? 0 : 1) + (lower ? 0 : 1) + (digit ? 0 : 1);

        if (s.length() > 20) {
            int del = s.length() - 20;
            //Reduce the number of replacement operation by deletion
            if (del <= delete[0])
                change -= del;
            else if (del - delete[0] <= 2 * delete[1])
                change -= delete[0] + (del - delete[0]) / 2;
            else
                change -= delete[0] + delete[1] + (del - delete[0] - 2 * delete[1]) / 3;

            return del + Math.max(check_req, change);
        } else
            return Math.max(6 - s.length(), Math.max(check_req, change));
    }
}
