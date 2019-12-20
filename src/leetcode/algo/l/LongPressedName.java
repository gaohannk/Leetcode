package leetcode.algo.l;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int i = 1, j = 1;
        int countA = 0, countB = 0;
        while (i < name.length() && j < typed.length()) {
            while (i < name.length() && name.charAt(i) == name.charAt(i - 1)) {
                countA++;
                i++;
            }
            while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
                countB++;
                j++;
            }
            if (name.charAt(i - 1) != typed.charAt(j - 1)) {
                return false;
            } else {
                if (countA > countB) {
                    return false;
                }
            }
            if (i == name.length() || j == typed.length()) {
                break;
            }
            i++;
            j++;
            countA = 0;
            countB = 0;
        }
        if (i != name.length()) {
            return false;
        }

        if (j < typed.length()) {
            while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
                countB++;
                j++;
            }
        }
        if (j < typed.length())
            return false;

        if (name.charAt(i - 1) != typed.charAt(j - 1)) {
            return false;
        } else {
            if (countA > countB) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    }
}
