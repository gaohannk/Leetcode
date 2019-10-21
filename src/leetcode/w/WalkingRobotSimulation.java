package leetcode.w;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, x = 0, y = 0, maxDis = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        HashMap<Integer, HashSet<Integer>> xobj = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yobj = new HashMap<>();

        for (int[] obstacle : obstacles) {
            HashSet<Integer> xset = xobj.getOrDefault(obstacle[0], new HashSet<>());
            xset.add(obstacle[1]);
            xobj.put(obstacle[0], xset);
            HashSet<Integer> yset = yobj.getOrDefault(obstacle[1], new HashSet<>());
            yset.add(obstacle[0]);
            yobj.put(obstacle[1], yset);
        }


        for (int command : commands) {
            if (command > 0) {
                while (command-- > 0) {
                    if (dx[dir] == 0) {
                        if (xobj.containsKey(x) && xobj.get(x).contains(y + dy[dir])) {
                            break;
                        }
                        y += dy[dir];
                    } else {
                        if (yobj.containsKey(y) && yobj.get(y).contains(x + dx[dir])) {
                            break;
                        }
                        x += dx[dir];
                    }
                }
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            }
            maxDis = Math.max(maxDis, x * x + y * y);
        }
        return maxDis;
    }
}
