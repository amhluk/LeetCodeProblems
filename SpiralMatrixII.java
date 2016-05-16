// 59. Spiral Matrix II
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if (n == 0) {
            return ret;
        }
        int a = n; //max column 
        int b = n; //max row
        int row = 0;
        int col = -1;
        int count = 1;
        for (;;) {
            // right
            for (int i = 0; i < a; i++) {
                ret[row][++col] = count++;
            }
            if (--b == 0) { // decrease row by 1 since row is already filled
                break;
            }
            
            // down
            for (int j = 0; j < b; j++) {
                ret[++row][col] = count++;
            }
            if (--a == 0) { 
                break;
            }
            
            // left
            for (int i = 0; i < a; i++) {
                ret[row][--col] = count++;
            }
            if (--b == 0) {
                break;
            }
            
            // down
            for (int j = 0; j < b; j++) {
                ret[--row][col] = count++;
            }
            if (--a == 0) {
                break;
            }
        }
        return ret;
    }
}