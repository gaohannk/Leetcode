package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/
/*
 * Whenever an element is poll() from heap, push the element below it to heap, 
 * only push the element right to it to heap when it's in first row. So we can avoid duplicates.
 */
/*
 * 从左到右，从上到下添加，直到队列元素个数为k并保持k，只添加比队列最大元素小的元素，队列始终保持第1到k大元素。
 * 当下一行第一个元素比队列中最大的元素还要大时，说明剩下的未添加的元素都比第k大的大。
 * 此时队列中最大的元素即为第k大元素。
 */
public class KthSmallestElementinaSortedMatrix3 {
	public static int kthSmallest(int[][] matrix, int k) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < m; i++) {
			printPQ(new PriorityQueue<>(pq));
			if (pq.size() == k && matrix[i][0] > pq.peek()) {
				break;
			}
			for (int j = 0; j < n; j++) {
				if (pq.size() == k) {
					if (pq.peek() > matrix[i][j]) {
						pq.poll();
						pq.offer(matrix[i][j]);
					}
				} else {
					pq.offer(matrix[i][j]);
				}
			}
		}
		return pq.peek();
	}

	private static void printPQ(PriorityQueue<Integer> pq) {
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 1, 3, 12
		// 6, 7, 13
		// 11,14,14
		int matrix[][] = { { 1, 3, 12 }, { 6, 7, 13 }, { 11, 14, 14 } };
		int k = 6;
		System.out.println("res:" + kthSmallest(matrix, k));
	}
}
