package company.hardforme;

import java.util.*;

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
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums1.length == 0 || nums2.length == 0) {
			return res;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] + a[2]));

		for(int i = 0; i < Math.min(k, nums1.length); i++) {
			// For every numbers in nums1, its best partner(yields min sum) always starts from nums2[0] since arrays are all sorted;
			// Fix index for nums2
			pq.add(new int[]{0, nums1[i], nums2[0]});
		}
		for(int i = 0; i < k && !pq.isEmpty(); i++) {
			int[] curr = pq.poll();
			res.add(Arrays.asList(curr[1], curr[2]));
			if(curr[0] < nums2.length - 1) {
				/**
				 * And for a specific number in nums1, its next candidate could be [this specific number] + nums2[current_associated_index + 1], unless out of boundary;
				 */
				// <new index, value in nums1, value in nums2>
				pq.add(new int[]{curr[0] + 1, curr[1], nums2[curr[0] + 1]});
			}
		}
		return res;
	}

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3};
        int nums2[] = {1, 1, 1};
        int k = 3;
        List<List<Integer>> res = kSmallestPairs(nums1, nums2, k);
        for (int i = 0; i < k; i++) {
            System.out.println(res.get(i));
        }
    }
}
