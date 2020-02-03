package leetcode.algo.d;

import java.util.*;

/*Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

*/
public class DesignSnakeGame {
    class SnakeGame {
        char[][] board;
        int score;
        int[][] food;
        int cur;
        Deque<int[]> positions;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            this.board = new char[height][width];
            this.score = 0;
            this.food = food;
            this.positions = new LinkedList<>();
            positions.addFirst(new int[]{0, 0});
            this.cur = 1;
            if (food.length > 0) {
                board[food[0][0]][food[0][1]] = 'F';
            }
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            int x = positions.peekFirst()[0];
            int y = positions.peekFirst()[1];
            int nextX = 0, nextY = 0;

            if (direction.equals("U")) {
                nextX = x - 1;
                nextY = y;
            } else if (direction.equals("L")) {
                nextX = x;
                nextY = y - 1;
            } else if (direction.equals("R")) {
                nextX = x;
                nextY = y + 1;
            } else if (direction.equals("D")) {
                nextX = x + 1;
                nextY = y;
            }

            if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length) {
                return -1; // game over
            }

            Iterator<int[]> iterator = positions.iterator();
            while (iterator.hasNext()) {
                int[] p = iterator.next();

                if (p[0] == nextX && p[1] == nextY) {
                    if (iterator.hasNext()) { // if hasNext ==false, the last one. continue
                        return -1; // bits itself
                    }
                }
            }

            if (board[nextX][nextY] == 'F') {
                positions.offerFirst(new int[]{nextX, nextY});
                score++;
                board[food[cur - 1][0]][food[cur - 1][1]] = 'X';
                if (cur < food.length) {
                    board[food[cur][0]][food[cur][1]] = 'F';
                    cur++;
                }
                return score;
            }
            positions.offerFirst(new int[]{nextX, nextY});
            positions.pollLast();
            return score;
        }
    }
}