package leetcode.algo.m;

public class Maximum69Number {
    public int maximum69Number(int num) {
        String number = String.valueOf(num);
        String res = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '6') {
                res = number.substring(0, i) + "9" + number.substring(i + 1);
                break;
            }
        }
        return Integer.parseInt(res);
    }

    public int maximum69Number2(int num) {
        char[] number = String.valueOf(num).toCharArray();
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '6') {
                number[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(number));
    }
}
