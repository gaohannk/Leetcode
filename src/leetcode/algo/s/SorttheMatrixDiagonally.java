package leetcode.algo.s;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 */
public class SorttheMatrixDiagonally {
    public static int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int max = Math.max(row, col);

        int res[][] = new int[row][col];
        int starty = max - 1;
        int startx = 0;
        for (int i = max - 1; i >= -max + 1; i--) {
            List<Integer> temp = new LinkedList<>();
            int y = starty, x = startx;

            while (y >= 0 && y <= col - 1 && x <= row - 1 && x >= 0) {
                temp.add(mat[x++][y++]);
            }

            Collections.sort(temp);

            int id = 0;
            y = starty;
            x = startx;
            while (y >= 0 && y <= col - 1 && x <= row - 1 && x >= 0) {
                res[x++][y++] = temp.get(id++);
            }
            if (i <= 0) {
                starty = 0;
                startx++;
            } else {
                starty--;
                startx = 0;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1}, {2, 2, 1}, {1, 1, 1}, {2, 3, 1}, {3, 5, 1}};
//        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        for (int[] line : mat) {
            for (int a : line) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
        int[][] res = diagonalSort(mat);
        for (int[] line : res) {
            for (int a : line) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
