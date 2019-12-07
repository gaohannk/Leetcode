package company.microsoft;

/**
 * 只有大写和小写字母组成，要求返回一个大写字母，which is the largest alphabetically order and occurs both in lower and upper cases in the string。
 * 比如"aAbxeEX"，A，E， X都符合题意，但X的字母序比较大，所以返回X。
 */
public class RemoveLargestCharAppearInLowerAndUpperCase {
    public static char solution(String s) {

        int[] upper = new int[26];
        int[] lower = new int[26];
        int res = -1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper[s.charAt(i) - 'A'] = 1;
            } else if (Character.isLowerCase(s.charAt(i))) {
                lower[s.charAt(i) - 'a'] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (upper[i] == 1 && lower[i] == 1) {
                res = Math.max(res, i);

            }
        }
        return (char) (res + 'A');
    }


    public static void main(String[] args) {
        System.out.println(solution("aAbxeEX"));
    }
}
