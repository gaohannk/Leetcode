package leetcode;

import java.util.PriorityQueue;

import leetcode.KthSmallestElementinaSortedMatrix2.Element;

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
public class KthSmallestElementinaSortedMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] rows = new int[n];
		int result = matrix[0][0];
		while (k-- > 0) {
			int smallest = Integer.MAX_VALUE;
			int colOfSmallest = 0;
			for (int col = 0; col < n; col++) {
				if (rows[col] == n) {
					continue;
				}
				System.out.println("col:"+col+" rows[col]:"+rows[col]);
				if (matrix[rows[col]][col] <= smallest) {
					System.out.println("matrix[rows[col]][col]:"+matrix[rows[col]][col]+" smallest:"+smallest);
					smallest = matrix[rows[col]][col];
					colOfSmallest = col;
					result = smallest;
					System.out.println("smallest:"+smallest+" colOfSmallest:"+colOfSmallest);
				}
				System.out.println("-------------------");
			}
			rows[colOfSmallest]++;
			System.out.println("colOfSmallest:"+colOfSmallest+" rows[colOfSmallest]:"+rows[colOfSmallest]);
			System.out.println("====================");
		}
		return result;
	}
	public static void main(String[] args){
		// 1, 3, 12
		// 6, 7, 13
		// 11,14,14
		int matrix[][] = {{1,3,12},{6,7,12},{11,14,14}};
		int k=6;
		System.out.println("res:"+kthSmallest(matrix, k));
	}
}
