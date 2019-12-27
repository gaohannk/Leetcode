package leetcode.algo;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        String num = "";
        int j = 0, i = 0;
        for (; i < word.length() && j < abbr.length(); ) {
            if (Character.isAlphabetic(abbr.charAt(j))) {
                if (!num.equals("")) {
                    i += Integer.parseInt(num);
                    num = "";
                    continue;
                }
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                j++;
                i++;
            } else {
                if (abbr.charAt(j) == '0' && num.equals(""))
                    return false;
                num += abbr.charAt(j);
                j++;
            }
        }
        if (!num.equals("")) {
            int pass = Integer.parseInt(num);
            i += pass;
        }
        return i == word.length() && j == abbr.length();
    }
}
