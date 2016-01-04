package leetcode;

/* Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII2 {
	public static int nthUglyNumber(int n) {
		int ugly[] = new int[n];
		int count = 1;
		ugly[0] = 1;
		while (count < n) {
			int min = Integer.MAX_VALUE;
			int flag=0;
			for (int i = 0; i < count; i++) {
				if (ugly[i] * 2 > ugly[count - 1] && min > ugly[i] * 2) {
					min = ugly[i] * 2;
					flag=1;
					break;
				}
			}
			for (int i = 0; i < count; i++) {
				if (ugly[i] * 3 > ugly[count - 1] && min > ugly[i] * 3) {
					min = ugly[i] * 3;
					flag=2;
					break;
				}
			}
			for (int i = 0; i < count; i++) {
				if (ugly[i] * 5 > ugly[count - 1] && min > ugly[i] * 5) {
					min = ugly[i] * 5;
					flag=3;
					break;
				}
			}
			ugly[count] = min;
			if(count==n-160){
				System.out.println(flag);
				System.out.println(min/5);
			}
			count++;
		}
		return ugly[count - 1];
	}

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1548));
		//System.out.println(1076168025);
	}
}
