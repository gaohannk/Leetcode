package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * CGiven an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res= new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                boolean[] flag = new boolean[]{false, false};
                boolean[][] visit = new boolean[matrix.length][matrix[0].length];
                DFS(i,j,matrix[i][j],matrix,visit,flag);
                if(flag[0] && flag[1])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }

    private static void DFS(int i, int j,int value, int[][] matrix,boolean[][] visit, boolean[] flag) {
        if(i<0 ||j<0) {
            flag[0] = true;
            return;
        }
        if(i>=matrix.length||j>=matrix[0].length) {
            flag[1] = true;
            return;
        }
        if(flag[0] && flag[1])
            return;
        if(visit[i][j] ||matrix[i][j]>value)
            return;
        visit[i][j]=true;
        DFS(i-1,j,matrix[i][j],matrix,visit,flag);
        DFS(i,j-1,matrix[i][j],matrix,visit,flag);
        DFS(i+1,j,matrix[i][j],matrix,visit,flag);
        DFS(i,j+1,matrix[i][j],matrix,visit,flag);
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic(matrix).forEach( item -> System.out.println(item[0]+","+item[1]));
    }

}
