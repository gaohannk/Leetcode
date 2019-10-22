package company.microsoft;

/**
 * 5(OST)给定⼀个string，变量名riddle，只有⼩写字⺟以及question mark
 * 组成，要求⽤'a'~'z'替换掉所有'?'，保证任意相邻的字符不相同
 * ⽐如riddle = ab?ac?，如果我们返回的是abcacd就是正确的。 ⽐如riddle = ?????????, 如果我们返回
 * abcdefghi就是正确的。 Codility的test case应该是包括了 (1)新的返回的string是否⻓度和原先string
 * 相等 (2) 原先问号位置的两边是否和replaced character相等
 */
public class NoSameCharNebour {

    public String replace(String riddle) {
        int left = 0, right = 0, n = riddle.length();
        char candidate1 = '*', candidate2 = '*', leftChar, rightChar;
        StringBuilder sb = new StringBuilder();
        while (left < n && right < n) {
            while (left < n && Character.isLetter(riddle.charAt(left))) {
                sb.append(riddle.charAt(left++));
            }
            // now is not reached the end, we find the first '?'
            right = left;
            while (right < n && riddle.charAt(right) == '?') {
                right++;
            }
            leftChar = left >= 0 ? riddle.charAt(left - 1) : '*';
            rightChar = right < n ? riddle.charAt(right) : '*';
            // now we've found the continuous '?' where left <= i < right where
            //riddle[i] = '?'
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == leftChar || c == rightChar)
                    continue;
                if (candidate1 == '*') {
                    candidate1 = c;
                } else if (candidate2 == '*') {
                    candidate2 = c;
                } else {
                    break;
                }
            }
            // now 2 candidates found, start filling the sb
            for (int i = left; i < right; i++) {
                sb.append(i % 2 == 0 ? candidate1 : candidate2);
            }
            candidate1 = '*';
            candidate2 = '*';

            left = right;
        }
        return sb.toString();
    }
}
