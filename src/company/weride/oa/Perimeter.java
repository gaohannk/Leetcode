package company.weride.oa;

import java.util.Scanner;

public class Perimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            String[] splits = line.split(" ");

            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(splits[j]);
            }
        }

        int res = getPerimeter(matrix);
        System.out.println(res);
    }

    public static int getPerimeter(int[][] matrix) {
        int res = 0;
        int dupEdge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res += matrix[i][j];
                dupEdge += getDuplicateEdge(matrix, i, j);
            }
        }
        return 4 * res - dupEdge;
    }

    private static int getDuplicateEdge(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) {
            return 0;
        }
        int count = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] == 1) {
            count++;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
            count++;
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] == 1) {
            count++;
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == 1) {
            count++;
        }
        return count;
    }
}
