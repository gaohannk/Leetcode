package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/
public class QueueReconstructionbyHeight2 {
	public static int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length <= 1) {
			return people;
		}
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		int n = people.length;
		int[][] ret = new int[n][];
		for (int i = 0; i < n; i++) {
			for (int j = 0, ahead = 0; j < n; j++) {
				if (ahead < people[i][1]) {
					ahead += (ret[j] == null || ret[j][0] >= people[i][0]) ? 1 : 0;
				} else if (ret[j] == null) {
					ret[j] = people[i];
					break;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		reconstructQueue(people);
	}
}
