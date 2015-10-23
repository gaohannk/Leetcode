package leetcode;

/* Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */
/* 定义Count[i]为i个元素能产生的Unique Binary Tree的数目，
 * 如果数组为空，毫无疑问，只有一种BST，即空树，
 * Count[0] =1
 * 如果数组仅有一个元素{1}，只有一种BST，单个节点
 * Count[1] = 1
 * 如果数组有两个元素{1,2}， 那么有如下两种可能
 * 1                2
 *  \             /
 *   2           1
 * Count[2] = Count[0] * Count[1]  (1为根的情况) 
 *          + Count[1] * Count[0]  (2为根的情况)
 * 三个元素的数组，可以发现BST的取值方式如下：
 * Count[3] = Count[0] * Count[2]  (1为根的情况)
 *          + Count[1] * Count[1]  (2为根的情况)
 *          + Count[2] * Count[0]  (3为根的情况)
 * 所以，由此观察，可以得出Count的递推公式为
 * Count[i] = ∑ Count[k] * [i-k]     0<=k<i-1
 * 问题至此划归为一维动态规划。
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				count[i] += count[j] * count[i - j - 1];
			}
		}
		return count[n];
	}
}
