package company.hired;

/**
 * 2.Deviation
 * Given an array of integer elements and an integer d please consider all the sequences of d consecutive elements in the array. For each sequence we compute the difference between the maximum and the minimum value of the elements in that sequence and name it the deviation.
 * Your task is to
 * write a function that computes the maximum value among the deviations of all the sequences considered above
 * print the value the standard output (stdout)
 * Note that your function will receive the following arguments:
 * v
 * o        which is the array of integers
 * d
 * o        which is an integer value giving the length of the sequences
 * Data constraints
 * the array will contain up to 100,000 elements
 * all the elements in the array are integer numbers in the following range: [1, 231 -1]
 * the value of d will not exceed the length of the given array
 * Efficiency constraints
 * your function is expected to print the result in less than 2 seconds
 * Example
 * Input        Output
 * v: 6, 9, 4, 7, 4, 1
 * d: 3        6
 * Explanation
 * The sequences of length 3 are:
 * 6 9 4 having the median 5 (the minimum value in the sequence is 4 and the maximum is 9)
 * 9 4 7 having the median 5 (the minimum value in the sequence is 4 and the maximum is 9)
 * 7 4 1 having the median 6 (the minimum value in the sequence is 1 and the maximum is 7)
 * The maximum value among all medians is 6
 */
public class Problem9 {
    public static int solution(int[] arra, int n) {
        int res = 0;
        for (int i = 0; i < arra.length - n + 1; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < i + 3; j++) {
                max = Math.max(max, arra[i]);
                min = Math.min(min, arra[i]);
            }
            res = Math.max(res, max - min);
        }
        return res;
    }
}
