package leetcode;

import java.util.stream.Stream;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int xstart = 0, xend = 0, ystart = 0, yend = 0;
        int i = 0;
        boolean flag = false;
        while (i < res.length) {
            int num = 0;
            if (flag) {
                // from top to bottom
                int x = xstart;
                int y = yend;
                int count = 0;
                while (y >= ystart && x <= xend) {
                    // System.out.println("haha"+res[i] + ',' + i);
                    res[i] = matrix[x][y];
                    // System.out.println("oo"+res[i] + ',' + i);
                    i++;
                    x++;
                    y--;
                    count++;
                }
                num = count;
            } else {
                // from bottom to top
                int x = xend;
                int y = ystart;
                //System.out.println("xend is "+ xend+"ystart is "+ystart+"xstart is "+xstart+"yend is "+ yend);
                int count = 0;
                while (x >= xstart && y <= yend) {
                    res[i] = matrix[x][y];
                    // System.out.print(res[i] + ":" + i);
                    i++;
                    x--;
                    y++;
                    count++;
                }
                num = count;
            }
            if (num == Math.min(matrix.length, matrix[0].length) && yend!=matrix[0].length) {
                ystart = ystart + 1 < matrix[0].length ? ystart + 1 : ystart;
                yend = yend + 1 < matrix[0].length ? yend + 1 : yend;
            } else if (i > res.length / 2) {
                xstart = xstart + 1 < matrix.length ? xstart + 1 : xstart;
                ystart = ystart + 1 < matrix[0].length ? ystart + 1 : ystart;
            } else if (i <= res.length / 2){
                xend = xend + 1 < matrix.length ? xend + 1 : xend;
                yend = yend + 1 < matrix[0].length ? yend + 1 : yend;
            }
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 111}, {4, 5, 6, 222}, {7, 8, 9, 333}};
        int res[] = findDiagonalOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }
}
