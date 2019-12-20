package leetcode.algo.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFormofInteger2 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        List<Integer> res = new ArrayList<Integer>();
        String s = String.valueOf(K);
        for (int i = A.length - 1, j = s.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : A[i];
            int y = j < 0 ? 0 : s.charAt(j) - '0';
            res.add(0, (x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return res;
    }
}
