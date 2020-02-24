package leetcode.algo;

/**
 * A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
 *
 * The world is modeled as a 2-D array of cells, where 0 represents uninfected cells, and 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.
 *
 * Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region -- the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night. There will never be a tie.
 *
 * Can you save the day? If so, what is the number of walls required? If not, and the world becomes fully infected, return the number of walls used.
 *
 * Example 1:
 * Input: grid =
 * [[0,1,0,0,0,0,0,1],
 * [0,1,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,0]]
 * Output: 10
 * Explanation:
 * There are 2 contaminated regions.
 * On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:
 *
 * [[0,1,0,0,0,0,1,1],
 * [0,1,0,0,0,0,1,1],
 * [0,0,0,0,0,0,1,1],
 * [0,0,0,0,0,0,0,1]]
 *
 * On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
 * Example 2:
 * Input: grid =
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output: 4
 * Explanation: Even though there is only one cell saved, there are 4 walls built.
 * Notice that walls are only built on the shared boundary of two different cells.
 * Example 3:
 * Input: grid =
 * [[1,1,1,0,0,0,0,0,0],
 * [1,0,1,0,1,1,1,1,1],
 * [1,1,1,0,0,0,0,0,0]]
 * Output: 13
 * Explanation: The region on the left only builds two new walls.
 * Note:
 * The number of rows and columns of grid will each be in the range [1, 50].
 * Each grid[i][j] will be either 0 or 1.
 * Throughout the described process, there is always a contiguous viral region that will infect strictly more uncontaminated squares in the next round.
 */

/**
 * BFS，找到所有病区及其可感染的健康区域数，存储在virusInfo[][]中；
 * 选择可感染区域数最大的病区，BFS建墙，将对应“1”置为“2”；
 * 对剩余病区进行感染操作，此处注意要对新感染区域进行记录（newInfected[][]），防止后面的病区与前面的病区连接，导致后面的病区多感染；
 * 结束条件，无“1”或无“0”
 */
public class ContainVirus {
    private static int[][] DIR = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int containVirus(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int sumVirus = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    sumVirus += 1;
                }
            }
        }

        if (sumVirus == 0 || sumVirus == row * col) {
            return 0;
        } else {
            return bfs(grid, sumVirus);
        }
    }

    private static int bfs(int[][] grid, int sumVirus) {
        int wallsNum = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean flagOne = true;
        while (flagOne) {

            int[][] newInfected = new int[row][col]; // !!!

            // 第一步，找各病毒区域及其可感染的健康区域数
            int[][] visitedVirus = new int[row][col];
            int[][] visitedHealth = new int[row][col];

            int[][] virusInfo = new int[row * col][3];
            int count = 0;

            int[] queueYVirus = new int[row * col];
            int[] queueXVirus = new int[row * col];
            int front = 0;
            int tail = 0;

            boolean falgTwo = true;
            while (falgTwo) {
                visitedHealth = new int[row][col]; // reset

                int startY = 0;
                int startX = 0;
                int temFlag = 0;
                for (int i = 0; i < row; i++) {
                    if (temFlag == 1) {
                        break;
                    }
                    for (int j = 0; j < col; j++) {
                        if (grid[i][j] == 1 && visitedVirus[i][j] == 0) {
                            startY = i;
                            startX = j;

                            temFlag = 1;
                            break;
                        }
                    }
                }

                if (temFlag == 1) {
                    virusInfo[count][0] = startY;
                    virusInfo[count][1] = startX;
                    virusInfo[count][2] = 0;

                    queueYVirus[tail] = startY;
                    queueXVirus[tail] = startX;
                    tail++;
                    visitedVirus[startY][startX] = 1;

                    while (front != tail) {
                        int temY = queueYVirus[front];
                        int temX = queueXVirus[front];
                        front++;

                        for (int dir = 0; dir < DIR.length; dir++) {
                            int nextY = temY + DIR[dir][0];
                            int nextX = temX + DIR[dir][1];

                            if (isValid(grid, visitedVirus, nextY, nextX)) {
                                if (grid[nextY][nextX] == 1) {
                                    queueYVirus[tail] = nextY;
                                    queueXVirus[tail] = nextX;
                                    tail++;
                                    visitedVirus[nextY][nextX] = 1;
                                } else if (grid[nextY][nextX] == 0 && visitedHealth[nextY][nextX] == 0) {
                                    virusInfo[count][2] += 1; // 可感染区域加1
                                    visitedHealth[nextY][nextX] = 1;
                                }
                            }
                        }
                    }

                    if (tail == sumVirus) { // sumVirus后面会变更！！！
                        falgTwo = false;
                    }

                    count += 1;
                } else {
                    falgTwo = false;
                }
            }

            if (count == 0) {
                return wallsNum;
            }
            // System.out.println("找到了" + count + "个病区");

            // 第二步，建墙
            int index = findMaxNumInfectInfo(virusInfo, count);
            int toBuildY = virusInfo[index][0];
            int toBuildX = virusInfo[index][1];

            int[] buildWallResult = countWallsNum(grid, toBuildY, toBuildX);
            wallsNum += buildWallResult[0];
            sumVirus -= buildWallResult[1]; // sumVirus 变更

			/*System.out.println("建了" + buildWallResult[0] + "堵墙，消灭了" + buildWallResult[1] + "个病毒");
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}*/

            // 第三步，感染
            for (int i = 0; i < count; i++) {
                int infectY = virusInfo[i][0];
                int infectX = virusInfo[i][1];
                if (!(infectY == toBuildY && infectX == toBuildX)) {
                    int infectedNum = infect(grid, newInfected, infectY, infectX);

                    sumVirus += infectedNum; // sumVirus 变更

                    // System.out.println("感染了" + infectedNum + "个区域");
                }
            }

            // 第四步，是否结束：无“1” 或者 无“0”
            if (isFinish(grid)) {
                flagOne = false;
            }
        }

		/*System.out.println("最终结果");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}*/

        return wallsNum;
    }

    private static int infect(int[][] map, int[][] newInfected, int startY, int startX) {
        int infectedNum = 0; // 感染的区域数

        int[][] visitedVirus = new int[map.length][map[0].length];
        int[] queueYVirus = new int[map.length * map[0].length];
        int[] queueXVirus = new int[map.length * map[0].length];
        int front = 0;
        int tail = 0;

        queueYVirus[tail] = startY;
        queueXVirus[tail] = startX;
        tail++;
        visitedVirus[startY][startX] = 1;

        while (front != tail) {
            int temY = queueYVirus[front];
            int temX = queueXVirus[front];
            front++;

            for (int dir = 0; dir < DIR.length; dir++) {
                int nextY = temY + DIR[dir][0];
                int nextX = temX + DIR[dir][1];

                if (isValid(map, visitedVirus, nextY, nextX)) {
                    if (map[nextY][nextX] == 1 && newInfected[nextY][nextX] == 0) {
                        queueYVirus[tail] = nextY;
                        queueXVirus[tail] = nextX;
                        tail++;
                    } else if (map[nextY][nextX] == 0) {
                        newInfected[nextY][nextX] = 1;

                        map[nextY][nextX] = 1;

                        infectedNum += 1;
                    }
                    visitedVirus[nextY][nextX] = 1;
                }
            }
        }

        return infectedNum;
    }

    private static int[] countWallsNum(int[][] grid, int startY, int startX) {
        int[] result = new int[2];
        int wall = 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] visitedVirus = new int[row][col];
        int[] queueYVirus = new int[row * col];
        int[] queueXVirus = new int[row * col];
        int front = 0;
        int tail = 0;

        queueYVirus[tail] = startY;
        queueXVirus[tail] = startX;
        tail++;
        visitedVirus[startY][startX] = 1;
        grid[startY][startX] = 2;

        while (front != tail) {
            int temY = queueYVirus[front];
            int temX = queueXVirus[front];
            front++;

            for (int k = 0; k < DIR.length; k++) {
                int nextY = temY + DIR[k][0];
                int nextX = temX + DIR[k][1];

                if (isValid(grid, visitedVirus, nextY, nextX)) {
                    if (grid[nextY][nextX] == 1) {
                        grid[nextY][nextX] = 2;

                        queueYVirus[tail] = nextY;
                        queueXVirus[tail] = nextX;
                        tail++;
                        visitedVirus[nextY][nextX] = 1; // 没用
                    } else if (grid[nextY][nextX] == 0) {
                        wall += 1;
                    }
                }
            }
        }

        result[0] = wall;
        result[1] = tail; // 被消除的 virus 数量

        return result;
    }

    private static int findMaxNumInfectInfo(int[][] virusInfo, int count) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (virusInfo[i][2] > max) {
                index = i;
                max = virusInfo[i][2];
            }
        }

        return index;
    }

    private static boolean isFinish(int[][] map) {
        boolean resultOne = true;
        boolean resultTwo = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    resultOne = false;
                }
                if (map[i][j] == 0) {
                    resultTwo = false;
                }
            }
        }

        return (resultOne || resultTwo);
    }

    private static boolean isValid(int[][] grid, int[][] visitedVirus, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return false;
        }

        if (grid[y][x] == 1 && visitedVirus[y][x] == 1) {
            return false;
        }

        return true;
    }
}
