package company.hired;

/**
 * Given an array of integer elements, a subsequence of this array is a set of consecutive elements from the array (i.e: given the array v: [7, 8, -3, 5, -1], a subsequence of v is 8, -3, 5)
 * Your task is to
 * write a function that finds a left and a right subsequence of the array that satisfy the following conditions
 * o        the two subsequences are unique (they don't have shared elements)
 * o        the difference between the sum of the elements in the right subsequence and the sum of the elements in the left subsequence is maximum
 * print the difference to the standard output (stdout)
 * Note that your function will receive the following arguments:
 * v
 * o        which is the array of integers
 * Data constraints
 * the array has at least 2 and at most 1,000,000 numbers
 * all the elements in the array are integer numbers in the following range: [-1000, 1000]
 * Efficiency constraints
 * your function is expected to print the result in less than 2 seconds
 * Example
 * Input        Output
 * v: 3, -5, 1, -2, 8, -2, 3, -2, 1        15
 * Explanation
 * The left sequence is : -5, 1, -2 and the right sequence is: 8, -2, 3.
 */
public class Problem8 {
    /**
     * 第一个pass用Kadane's algorithm，分别从左往右和从右往左算Max和Min。
     * 输入： {3, -5, 1, -2, 8, -2, 3, -2, 1}
     * Max so far from left: [3, -2, 1, -1, 8, 6, 9, 7, 8]
     * Min so far from left: [3, -5, -4, -6, 2, -2, 1, -2, -1]
     *
     * Max so far from right: [3, 3, 8, 7, 9, 1, 3, -1, 1]
     * Min so far from right: [3, -6, -1, -2, 6, -2, 1, -2, 1]
     *
     *
     * 第二个pass分别从左和右算出这一段之后的min/max，比如说
     * [3, -2, 1, -1, 8, 6, 9, 7, 8]
     * [3, 3, 1, -1, 8, 6, 9, 7, 8] <-- 因为是从左,3>-2
     * [3, 3, 3, -1, 8, 6, 9, 7, 8] 3>1
     * [3, 3, 3, 3, 8, 6, 9, 7, 8]
     * [3, 3, 3, 3, 8, 6, 9, 7, 8]
     * [3, 3, 3, 3, 8, 8, 9, 7, 8]
     * [3, 3, 3, 3, 8, 8, 9, 7, 8]
     * [3, 3, 3, 3, 8, 8, 9, 9, 8]
     * [3, 3, 3, 3, 8, 8, 9, 9, 9] <-结果
     *
     * 下面算min
     * [3, -5, -4, -6, 2, -2, 1, -2, -1]->[3, -5, -5, -6, -6, -6, -6, -6, -6]
     *
     *
     * 右边向左：
     * Max: [3, 3, 8, 7, 9, 1, 3, -1, 1]->[9, 9, 9, 9, 9, 3, 3, 1, 1]
     * Min: [3, -6, -1, -2, 6, -2, 1, -2, 1]->[-6, -6, -2, -2, -2, -2, -2, -2, 1]
     *
     *
     * 好，这时候你肯定很费解为毛要这样算。我们把他们拼在一起：
     * MaxLeft :[3, 3, 3, 3, 8, 8, 9, 9, 9]
     * MinRight:[-6, -6, -2, -2, -2, -2, -2, -2, 1]
     *
     * 如果计算MaxLeft[n]-MinRight[n+1]的最大绝对差，就可以得到不重叠的两个sub array的max。
     * 同理计算MinLeft和MaxRight，两轮最后胜出的就是结果。
     * @param v
     */
    public static void maxdiff(Integer[] v) {

    }
}
