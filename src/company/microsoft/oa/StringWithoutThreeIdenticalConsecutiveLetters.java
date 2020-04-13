package company.microsoft.oa;

public class StringWithoutThreeIdenticalConsecutiveLetters {
    public static void main(String[] args) {
        String s1 = "eedaaad";
        String s2 = "xxxtxxx";
        String s3 = "uuuuxaaaaxuuu";
        System.out.println(getLongestSubstring(s1));
        System.out.println(getLongestSubstring(s2));
        System.out.println(getLongestSubstring(s3));
    }

    private static String getLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                count = 1;
            }
            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
