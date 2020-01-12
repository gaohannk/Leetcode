package company.oracle.high;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            int digit = sum % 10;
            carry = sum / 10;
            res.append(digit);
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                int sum = num1.charAt(i) - '0' + carry;
                int digit = sum % 10;
                carry = sum / 10;
                res.append(digit);
                i--;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                int sum = num2.charAt(j) - '0' + carry;
                int digit = sum % 10;
                carry = sum / 10;
                res.append(digit);
                j--;
            }
        }
        // Last step handle carry
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
