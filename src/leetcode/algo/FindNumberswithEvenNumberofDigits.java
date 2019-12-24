package leetcode.algo;

public class FindNumberswithEvenNumberofDigits {
	public int findNumbers(int[] nums) {
		int res = 0;
		for (int num : nums) {
			int count = 0;
			while (num > 0) {
				num = num / 10;
				count++;
			}
			if (count % 2 == 0) {
				res++;
			}
		}
		return res;
	}
}
