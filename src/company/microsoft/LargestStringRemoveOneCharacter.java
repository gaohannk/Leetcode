package company.microsoft;

/**
 * (OTS).给定⼀个string, 问如何去掉⼀个character，使得剩下的string
 * 最⼩
 */
public class LargestStringRemoveOneCharacter {
    public String removeOneChar(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return s.substring(0, i) + s.substring(i + 1);
            }
        }

        throw new IllegalArgumentException("No possible character exist");
    }
}
