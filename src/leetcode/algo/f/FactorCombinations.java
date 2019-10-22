package leetcode.algo.f;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * <p>
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples:
 * input: 1
 * output:
 * <p>
 * []
 * input: 37
 * output:
 * <p>
 * []
 * input: 12
 * output:
 * <p>
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * input: 32
 * output:
 * <p>
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 */
//O(2^N) 时间 O(N) 空间
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, 2, list, result);
        return result;
    }

    public void helper(int n, int start, List<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() > 1) {  //the original input is not counted in
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= Math.sqrt(n); i++) {   //这里只要到根号n就好了
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
