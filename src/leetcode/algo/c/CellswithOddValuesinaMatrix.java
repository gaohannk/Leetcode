package leetcode.algo.c;

public class CellswithOddValuesinaMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] column = new int[m];

        for (int[] item : indices) {
            row[item[0]] += 1;
            column[item[1]] += 1;
        }

        int columnOddCount = 0;
        for (int i = 0; i < column.length; i++) {
            if (column[i] % 2 == 1) {
                columnOddCount++;
            }
        }

        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 == 0) {
                count += columnOddCount;
            } else {
                count += m - columnOddCount;
            }
        }

        return count;
    }
}
