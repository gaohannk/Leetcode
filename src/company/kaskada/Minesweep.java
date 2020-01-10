package company.kaskada;

import java.util.Random;

/**
 * # Minesweeper is a game where the objective is correctly identify the location of
 * # all mines in a given grid. You are given a uniform grid of gray squares in the
 * # beginning of the game. Each square contains either a mine (indicated by a value
 * # of 9), or an empty square. Empty squares have a number indicating the count of
 * # mines in the adjacent squares. Empty squares can have counts from zero (no
 * # adjacent mines) up to 8 (all adjacent squares are mines).
 * #
 * # If you were to take a complete grid, for example, you can see which squares
 * # have mines and which squares are empty
 * #
 * # 0  0  0  0  0
 * # 0  0  0  0  0
 * # 1  1  1  0  0
 * # 1  9  1  0  0
 * # 1  2  2  1  0
 * # 0  1  9  1  0
 * # 0  1  1  1  0
 * #
 * # The squares with "2" indicate that there 2 mines adjacent to that particular
 * # square.
 * #
 * # Please write functions to construct the playing field given the size and number
 * # of mines.
 */
public class Minesweep {

    int[] dirX = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
    int[] dirY = new int[]{0, 1, 0, -1, -1, -1, 1, 1};

    public int[][] minesweeper(int row, int col, int number) {
        // row col number is invalid: negative
        // number ==0 , return fast
        // number > row * col ; invalid

        int[][] matrix = new int[row][col];

        Random rand = new Random();
        // place the mine in grid
        while (number > 0) {
            int x = rand.nextInt(row); // return integer from range 0 to row
            int y = rand.nextInt(col);

            if (matrix[x][y] != 9) {
                matrix[x][y] = 9;
                number--;
            } else {
                continue;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 9) {
                    int count = getCount(matrix, i, j);
                    matrix[i][j] = count;
                }
            }
        }
        return matrix;
    }

    /**
     * Get adjacent number of mines
     */
    public int getCount(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        for (int k = 0; k < 8; k++) {
            // check boundary
            if (i + dirX[k] >= row || i + dirX[k] < 0 || j + dirY[k] >= row || j + dirY[k] < 0) {
                continue;
            }
            if (matrix[i + dirX[k]][j + dirY[k]] == 9) {
                count++;
            }
        }
        return count;
    }
}
