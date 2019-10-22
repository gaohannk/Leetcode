package leetcode.algo.t;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        int diff = 'a' - 'A';
        for (int i = 0; i < arr.length; i++) {
            if ((int) arr[i] >= 65 && (int) arr[i] <= 90) {
                arr[i] = (char) ((int) arr[i] + diff);
            }
        }
        return String.valueOf(arr);
    }

    public String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' <= 26)
                sb.append((char) (c - 'A' + 'a'));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
