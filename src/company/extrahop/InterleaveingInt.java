package company.extrahop;

public class InterleaveingInt {
    public static int interleave(int a, int b) {
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < first.length() && j < second.length()) {
            sb.append(first.charAt(i++));
            sb.append(second.charAt(j++));
        }
        if (i < first.length()) {
            sb.append(first.substring(i));
        }
        if (j < second.length()) {
            sb.append(second.substring(j));
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(interleave(123,456));
    }
}
