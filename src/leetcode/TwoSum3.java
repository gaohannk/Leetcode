package leetcode;

import java.util.HashMap;

/* Given an array of integers, find two numbers such that they add up to a specific target 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
/* Time complexity of this solution: O(n)
 */
public class TwoSum3 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                int[] res = {map.get(target - x) + 1, i};
                return res;
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
