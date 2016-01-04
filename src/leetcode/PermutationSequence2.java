package leetcode;

/* The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
/* 直接生成第K个排列，方法如下：
 * 第一个数字确定时的全排列有(n-1)!,则第一个符号应该是第k/(n-1)!+1个,继续在剩下的序列中找第k=(k%(n-1)!)个排列
 * 第二个数字确定时的全排列有(n-2)!,则第二个符号应该是第k/(n-2)!+1个,以此类推；
 * 例如 n=4;k=17
 * 17/3!=2 所以第一个数字是3
 */
public class PermutationSequence2 {
	public static String getPermutation(int n, int k) {
		StringBuffer num = new StringBuffer("123456789");
		StringBuffer str = new StringBuffer();
		int total = 1;
		for (int i = 2; i <= n; i++) {
			total *= i;
		}
		for (int i = 0; i < n; i++) {
			total /= (n - i);
			int index = (k - 1) / total;
			str.append(num.charAt(index));
			num.deleteCharAt(index);
			//System.out.println(num.toString());
			k -= index * total;
		}
		return str.toString();
	}
	public static void main(String[] args){
		System.out.println(getPermutation(4, 17));
	}
}
