package company.weride.phone;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

        public void backtrack(int row, int col, int d) {
            visited.add(new Pair(row, col));
            robot.clean();
            // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
            for (int i = 0; i < 4; ++i) {
                int newD = (d + i) % 4;
                int newRow = row + directions[newD][0];
                int newCol = col + directions[newD][1];

                if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                    backtrack(newRow, newCol, newD);
                    // reset previous position and direction
                    goBack();
                }
                // turn the robot following chosen direction : clockwise
                robot.turnRight();
            }
        }

        public void cleanRoom(Robot robot) {
            this.robot = robot;
            backtrack(0, 0, 0);
        }
    }
}
