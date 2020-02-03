package leetcode.algo.p;

/* Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
/* We can recursively solve this problem. Swap each element with each element after it.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        permute(num, 0, result);
        return result;
    }

    public void permute(int[] num, int start, List<List<Integer>> result) {
        if (start >= num.length) {
            List<Integer> item = new ArrayList<Integer>();
            for (int h = 0; h < num.length; h++) {
                item.add(num[h]);
            }
            result.add(item);
            return;
        }
        for (int j = start; j < num.length; j++) {
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
