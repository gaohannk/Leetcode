package leetcode.algo.c;

import java.util.LinkedList;
import java.util.Queue;

public class ConfusingNumberII {
    int[] digits = new int[]{0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < digits.length; i++) {
                int nn = n * 10 + digits[i];
                if (nn > N) {
                    return res;
                }
                if (nn != 0) {
                    queue.offer(nn);
                }
                if (isConfusing(nn)) {
                    res++;
                }
            }
        }
        return -1;
    }

    private boolean isConfusing(int N) {
        String s = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7')
                return false;
            if (c == '6')
                sb.append('9');
            else if (c == '9')
                sb.append('6');
            else
                sb.append(c);
        }
        return !sb.reverse().toString().equals(s);
    }
}
