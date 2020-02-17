package leetcode.algo.r;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * Notes:
 *
 * The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 */

/**
 * Mark the cell as visited and clean it up.
 *
 * Explore 4 directions : up, right, down, and left (the order is important since the idea is always to turn right) :
 *
 * Check the next cell in the chosen direction :
 *
 * If it's not visited yet and there is no obtacles :
 *
 * Move forward.
 *
 * Explore next cells backtrack(new_cell, new_direction).
 *
 * Backtrack, i.e. go back to the previous cell.
 *
 * Turn right because now there is an obstacle (or a virtual obstacle) just in front.
 */
public class RobotRoomCleaner {
    class Robot {

        public void turnRight() {
        }

        public void turnLeft() {
        }

        public boolean move() {
            return false;
        }

        public void clean() {
        }
    }

    public class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Pair o) {
            return Objects.equals(o.first, first) && Objects.equals(o.second, second);
        }

    }

    class Solution {
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<Pair> visited = new HashSet<>();
        Robot robot;

        public void goBack() {
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }

        public void helper(int row, int col, int d) {
            visited.add(new Pair(row, col));
            robot.clean();
            // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
            for (int i = 0; i < 4; ++i) {
                int newD = (d + i) % 4;
                int newRow = row + directions[newD][0];
                int newCol = col + directions[newD][1];

                if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                    helper(newRow, newCol, newD);
                    // reset previous position and direction
                    goBack();
                }
                // turn the robot following chosen direction : clockwise
                robot.turnRight();
            }
        }

        public void cleanRoom(Robot robot) {
            this.robot = robot;
            helper(0, 0, 0);
        }
    }
}
