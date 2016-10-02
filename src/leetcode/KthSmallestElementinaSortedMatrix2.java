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
public class KthSmallestElementinaSortedMatrix2 {
	static class Element {
		int x, y, val;

		public Element(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int x = 0, y = 0;
		int m = matrix.length, n = matrix[0].length;
		PriorityQueue<Element> pq = new PriorityQueue<Element>(11, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return e1.val - e2.val;
			}
		});
		pq.offer(new Element(x, y, matrix[x][y]));
		for (int i = 1; i <= k - 1; i++) {
			printPQ(new PriorityQueue<>(pq));
			Element e = pq.poll();
			// Go down to add element
			if (e.x + 1 < m) {
				pq.offer(new Element(e.x + 1, e.y, matrix[e.x + 1][e.y]));
			}
			// only add element from right when current element is at the first
			// row, then we are able to cover
			// all columns without any duplicates
			if (e.y + 1 < n && e.x == 0) {
				pq.offer(new Element(e.x, e.y + 1, matrix[e.x][e.y + 1]));
			}	
		}
		return pq.poll().val;
	}

	private static void printPQ(PriorityQueue<Element> pq) {
		while(!pq.isEmpty()){
			System.out.print(pq.poll().val+" ");
		}
		System.out.println();
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
