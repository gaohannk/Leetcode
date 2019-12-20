package leetcode.algo.a;

import java.util.ArrayList;
import java.util.List;

public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] a, int k) {

        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int digit = k % 10;
            k = k / 10;
            sum = (digit + a[i] + carry) % 10;
            carry = (digit + a[i] + carry) / 10;
            ans.add(0, sum);
        }

        while (k != 0) {
            int digit = k % 10;
            k = k / 10;
            sum = (digit + carry) % 10;
            carry = (digit + carry) / 10;
            ans.add(0, sum);
        }

        if (carry != 0)
            ans.add(0, carry);

        return ans;
    }
}
