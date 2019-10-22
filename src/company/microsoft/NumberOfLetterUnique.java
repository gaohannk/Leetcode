package company.microsoft;

/**
 * least number of letters to be removed so that occurrences of each letter is unique -> example: ‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌aabbbbccd -> 2 (bbbbccd / abbbbcc / aabbbbc / aabbbbd)
 */
public class NumberOfLetterUnique {
    public static int removeTimes(String s) {
        int count[] = new int[s.length() + 1];
        int i = 1, times = 1;
        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count[times]++;
                times = 1;
            } else {
                times++;
            }
            i++;
        }
        count[times]++;
        int res = 0;
        for (i = count.length - 1; i > 0; i--) {
            if (count[i] != 1 && count[i] != 0) {
                res += count[i] - 1;
                count[i - 1] += count[i] - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeTimes("abbccddsssseeeefffd"));
    }
}
