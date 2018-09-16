package leetcode;


/**
 * Created by gaohan on 5/26/18.
 */
public class MaskingPersonalInformation2 {
    public String maskPII(String S) {
        S = S.toLowerCase();
        StringBuilder s = new StringBuilder("");

        if (Character.isLetter(S.charAt(0))) {
            s = s.append(S.charAt(0)).append("*****");
            int i = 0;
            char prev = '0';

            while (S.charAt(i) != '@') {
                prev = S.charAt(i);
                i++;
            }

            s = s.append(prev);

            while (i < S.length()) {
                s = s.append(S.charAt(i));
                i++;
            }
            return s.toString();
        } else {
            S = S.replaceAll("[^\\d]", "");
            if (S.length() > 10) {
                s.append("+");
                for (int i = 0; i < S.length() - 10; i++) {
                    s.append("*");
                }
                s.append("-***-***-");
                for (int i = S.length() - 4; i < S.length(); i++) {
                    s.append(S.charAt(i));
                }
            } else {
                s.append("***-***-");
                for (int i = S.length() - 4; i < S.length(); i++) {
                    s.append(S.charAt(i));
                }
            }
        }
        return s.toString();
    }
}
