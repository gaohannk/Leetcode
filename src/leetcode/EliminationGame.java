package leetcode;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 */
// MTE
public class EliminationGame {
    public static int lastRemaining(int n) {
        if(n==1)
            return 1;
        boolean flag[] = new boolean[n + 1];
        boolean order =true;
        while (eliminate(flag,order) != 1) {
            order=!order;
        }
        for (int i = 1; i < flag.length; i++) {
            if(!flag[i])
                return i;
        }
        return 0;
    }

    private static int eliminate(boolean[] flag,boolean order) {
        boolean reverse = true;
        int count = 0;
        if(order) {
            for (int i = 1; i < flag.length; i++) {
                if (!flag[i]) {
                    if (reverse) {
                        flag[i] = true;
                        reverse = false;
                    } else {
                        reverse = true;
                        count++;
                    }
                }
            }
        }else{
            for (int i = flag.length-1; i >=1; i--) {
                if (!flag[i]) {
                    if (reverse) {
                        flag[i] = true;
                        reverse = false;
                    } else {
                        reverse = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.print(lastRemaining(6));
    }

}
