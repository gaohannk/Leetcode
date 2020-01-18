package company.smartnews.oa;

public class Problem1 {
    public static int insertNumber(int num) {
        String res = "";
        if (num >= 0) {
            String numAsStr = String.valueOf(num);
            int i = 0;
            while (i < numAsStr.length()) {
                if (numAsStr.charAt(i) - '0' < 5) {
                    break;
                }
                res += numAsStr.charAt(i);
                i++;
            }
            res += '5';
            if (i < numAsStr.length()) {
                res += numAsStr.substring(i);
            }
            return Integer.valueOf(res);
        } else {
            num = -num;
            String numAsStr = String.valueOf(num);
            int i = 0;
            while (i < numAsStr.length()) {
                if (numAsStr.charAt(i) - '0' > 5) {
                    break;
                }
                res += numAsStr.charAt(i);
                i++;
            }
            res += '5';
            if (i < numAsStr.length()) {
                res += numAsStr.substring(i);
            }
            return -1 * Integer.valueOf(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(insertNumber(8000));
        System.out.println(insertNumber(-8000));
        System.out.println(insertNumber(8123));
        System.out.println(insertNumber(-8123));
        System.out.println(insertNumber(2123));
        System.out.println(insertNumber(-2123));
        System.out.println(insertNumber(2183));
        System.out.println(insertNumber(-2183));
        System.out.println(insertNumber(5555));
        System.out.println(insertNumber(4));
        System.out.println(insertNumber(-4));
        System.out.println(insertNumber(-8));
        System.out.println(insertNumber(8));
        System.out.println(insertNumber(0));
        System.out.println(insertNumber(10000009));
    }
}
