package company.offerup.phone;

/**
 * A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions.
 *
 * Specifically, each cell can be either black or white. For each row and column, the instructions give the lengths of contiguous runs of black squares.  In the end, the instructions for both directions, of rows and columns, must all be satisfied by the same grid.
 *
 * For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of 2 black spaces, followed later by another run of 1 black space, and the rest of the row filled with white spaces.  If black spaces are represented by 0, and white by 1, these are valid solutions:
 *
 * [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
 *
 * This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
 *
 * Your job is to write a function to validate solutions against the instructions.  Given a 2D matrix (not necessarily square) representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.
 *
 * Example:
 *
 * instructions #1 =>  returns True
 * rows1    =  [], [1], [1,2], [1], [2]
 * columns1 =  [2,1], [1], [2], [1]
 *
 * Example solution matrix:
 *
 *
 * matrix1 ->
 *                                    row
 *                 +------------+     instructions
 *                 | 1  1  1  1 | <-- []
 *                 | 0  1  1  1 | <-- [1]
 *                 | 0  1  0  0 | <-- [1,2]
 *                 | 1  1  0  1 | <-- [1]
 *                 | 0  0  1  1 | <-- [2]
 *                 +------------+
 *                   ^  ^  ^  ^
 *                   |  |  |  |
 *   column       [2,1] | [2] |
 *   instructions      [1]   [1]
 *
 * Example instructions #2 =>  returns False
 * (same matrix as above)
 *
 * rows2    =  [], [], [1], [1], [1,1]
 * columns2 =  [2], [1], [2], [1]
 *
 * Example #3 => returns False
 *
 * matrix2 = [
 * [ 1, 1 ],
 * [ 0, 0 ],
 * [ 0, 0 ],
 * [ 1, 0 ]
 * ]
 *
 * rows3    = [], [2], [2], [1]
 * columns3 = [1, 1], [3]
 */
public class Nongram {
}
