package company.microsoft.oa;

public class MaximumPossibleValue {
    public int MaximumPossibleValue(int N) {
        // write your code here
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(N)));
        int flag = N >= 0 ? 1 : -1;
        if (N >= 0) {
            int idx = 0;
            while (idx < sb.length() && (sb.charAt(idx) - '0') >= 5) {
                idx++;
            }
            sb.insert(idx, 5);
        } else {
            int idx = 0;
            while (idx < sb.length() && (sb.charAt(idx) - '0') <= 5) {
                idx++;
            }
            sb.insert(idx, 5);
        }

        int val = Integer.parseInt(sb.toString());
        return flag * val;
    }
}
