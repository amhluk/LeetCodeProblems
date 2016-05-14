// 62. Unique Paths
public class Solution {
    /* BACKTRACKING SOLUTION
    private int backTrack(int i, int j, int m, int n, int[][] mat) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i >= m || j >= n) {
            return 0;
        }
        
        if (mat[i + 1][j] == -1) {
            mat[i + 1][j] = backTrack(i + 1, j, m, n, mat);
        }
        if (mat[i][j + 1] == -1) {
            mat[i][j + 1] = backTrack(i, j + 1, m, n, mat);
        }
        return mat[i + 1][j] + mat[i][j + 1];
    }
    
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }
        return backTrack(0 , 0, m, n, mat);
    } */
    
    /* DYNAMIC PROGRAMMING SOLUTION  */
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        
        // set edges as 1 since there is only one path to these coordinates
        for (int i = 0; i < m; i++) {
            mat[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            mat[m - 1][j] = 1;
        }
        
        // calculate unique paths for each i, j
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                mat[i][j] = mat[i + 1][j] + mat[i][j+1];
            }
        }
        
        // return unique paths from 0, 0
        return mat[0][0];
    }
}