package company.oracle.phone;

public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        boolean negetive = false;
        if (x < 0) {
            negetive = true;
            x = x * -1;
        }
        while (x > 0) {
            sb.append(x % 10);
            x = x / 10;
        }
        int res = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (sb.charAt(i) - '0') > 7))
                return 0;
            res = res * 10 + (sb.charAt(i) - '0');


        }
        return negetive ? -1 * res : res;
    }
}
