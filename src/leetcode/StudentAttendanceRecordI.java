package leetcode;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int count = 0, late = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
            } else if (i > 0 && s.charAt(i) == 'L' && s.charAt(i) == s.charAt(i - 1)) {
                late++;
            } else {
                late = 1;
            }
            if (count > 2 || late >= 3) {
                return false;
            }
        }
        return true;
    }
}
