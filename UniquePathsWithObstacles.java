// 63. Unique Paths II
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] mat = new int[m + 1][n + 1];
        
        // set one of m - 1, n or m, n - 1 as 1
        mat[m - 1][n] = 1;
        
        // calculate unique paths for each i, j
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                mat[i][j] = (obstacleGrid[i][j] == 1)? 0 : mat[i + 1][j] + mat[i][j+1]; // if there is a obstacle set as 0
            }
        }
        
        // return unique paths from 0, 0
        return mat[0][0];
    }
}