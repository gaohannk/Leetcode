package leetcode.algo.r;

import java.util.LinkedList;
import java.util.Random;

/*Given an array of integers with possible duplicates, randomly output the list of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either list 2, 3, or 4 randomly. Each list should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

*/
public class RandomPickIndex2 {
    public static class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int counter = 0;
            // get number of appear in the array
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    counter++;
                }
            }

            if (counter == 0)
                return -1;

            int rand = Math.abs(new Random().nextInt()) % counter;

            counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (counter == rand)
                        return i;
                    counter++;
                }
            }

            return -1;

        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 3, 3};
        Solution solution = new RandomPickIndex2.Solution(nums);
        System.out.println(solution.pick(3));
    }
}
