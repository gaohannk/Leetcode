package leetcode;
/* Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * Hint:
 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
import java.util.Arrays;

public class HIndexII {
	public static int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		if (citations.length == 1)
			return citations[0] >= 1 ? 1 : 0;
		int h = 1;
		for (int i = citations.length - 1; i >= 0; i--) {
			if (h > citations[i])
				return h - 1;
			h++;
		}
		return h-1;
	}

	public static void main(String[] args) {
		int[] a = { 1,12,15 };
		System.out.println(hIndex(a));
	}
}
