package company.microsoft.oa;

public class MaxInsertstoObtainStringWithoutThreeConsecutiveA {

    private static int maxA(String s) {
        int count = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                count++;
            } else {
                res += 2 - count;
                count = 0;
            }
            if (count == 3) {
                return -1;
            }
        }

        res += 2 - count;
        return res;
    }

    private static int maxA2(String s) {
        int res = 0, count = 2;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count--;
            } else {
                if (count < 0) {
                    return -1;
                }

                res += count;
                count = 2;
            }
        }
        if (count < 0) {
            return -1;
        }

        return res + count;
    }

    public static void main(String[] args) {
        String s1 = "aabab";
        String s2 = "dog";
        String s3 = "aa";
        String s4 = "baaa";
        String s5 = "aaba";
        System.out.println(maxA(s1));
        System.out.println(maxA(s2));
        System.out.println(maxA(s3));
        System.out.println(maxA(s4));
        System.out.println(maxA(s5));
    }
}
