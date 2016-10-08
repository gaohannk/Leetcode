package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/
public class FindKPairswithSmallestSums {
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	/*	PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] + o1[2] > o2[0] + o2[1])
					return 1;
				else if (o1[0] + o1[2] < o2[0] + o2[1])
					return -1;
				return 0;
			}
		});
		*/
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();

		for (int i = 0; i < k && i < nums1.length; i++) {
			pq.add(nums1[i]);
		}
		for (int i = 0; i < k && i < nums2.length; i++) {
			pq2.add(nums2[i]);
		}
		LinkedList<int[]> res = new LinkedList<>();
		int[] item= {nums1[0],nums2[0]};
		res.add(item);
		for (int i = 0; i < k; i++) {

		}
		return res;
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 2, 3 };
		int nums2[] = { 1, 1, 1 };
		int k = 3;
		List<int[]> res = kSmallestPairs(nums1, nums2, k);
		for (int i = 0; i < k; i++) {
			System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
		}
	}
}
