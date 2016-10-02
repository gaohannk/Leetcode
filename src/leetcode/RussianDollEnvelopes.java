package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/
/*
Sort the original envelopes with one dimension, fit in as many as possible.
dp[i] stands for the maximum number when put envelopes i into others
init: dp[i] is 1 for all i
Transition: dp[i] = max(dp[j] for all possible envelope j which i can put in, j starts from 0 to i-1
 */
public class RussianDollEnvelopes {
	static class Pair {
		public Pair(int width, int height) {
			this.width = width;
			this.height = height;
		}

		int width;
		int height;
	}

	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0)
			return 0;
		Pair[] list = new Pair[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			list[i] = new Pair(envelopes[i][0], envelopes[i][1]);
		}
		int dp[] = new int[list.length];
		dp[0] = 1;
		Arrays.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.width > o2.width ? 1 : o1.width < o2.width ? -1 : 0;
			}
		});
		for (int i = 1; i < list.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (list[j].width == list[i].width)
					break;
				if (list[j].height < list[i].height)
					max = dp[j] > max ? dp[j] : max;
			}
			dp[i] = max + 1;
		}
		int globalMax = 0;
		for (int i = 0; i < dp.length; i++) {
			globalMax = dp[i] > globalMax ? dp[i] : globalMax;
		}
		return globalMax;
	}

	public boolean canFit(int[] e1, int[] e2) {
		if (e1[0] < e2[0] && e1[1] < e2[1])
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println(maxEnvelopes(envelopes));
	}
}
