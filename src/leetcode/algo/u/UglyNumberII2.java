package leetcode.algo.u;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/* Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII2 {
	public static int nthUglyNumber(int n) {
		Queue<Long> pq = new PriorityQueue<>();
		Set<Long> seen = new HashSet<>();
		pq.add(1L);
		n--;
		int[] prime = new int[]{2,3,5};
		while(n>0){
			long cur = pq.poll();
			System.out.println(cur);
			for(int p: prime) {
				if (!seen.contains(cur * p)) {
					seen.add(cur * p);
					pq.add(cur * p);
				}
			}
			n--;
		}
		return (int) (long) pq.poll();
	}

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
		//System.out.println(1076168025);
	}
}
