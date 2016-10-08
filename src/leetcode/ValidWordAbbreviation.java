package leetcode;

/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * <p>
 * A string such as "word" contains only the following valid abbreviations:
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 * <p>
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 * <p>
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * <p>
 * Return true.
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * <p>
 * Return false.
 */
public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abbr.length(); i++) {
            if (abbr.charAt(i) >= 'a' && abbr.charAt(i) <= 'z') {
                if (sb.length() != 0) {
                    if (sb.charAt(0) == '0')
                        return false;
                    index += Integer.parseInt(sb.toString()) + 1;
                    sb.delete(0, sb.length());
                }
                if (abbr.charAt(i) != word.charAt(index))
                    return false;
                index++;
            } else {
                sb.append(abbr.charAt(i));
            }
        }
        return index == word.length();
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));
    }
}
