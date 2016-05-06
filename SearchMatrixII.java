// 240. Search a 2D Matrix II
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // make sure dimensions are non-zero
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // get dimensions
        int M = matrix.length;
        int N = matrix[0].length;
      
        // skip if target is less than min, or greater than max
        if (target < matrix[0][0] || target > matrix[M-1][N-1]) {
            return false;
        }
         
        // step-wise linear search
        int row = 0;
        int column = N - 1;
        while (row < M && column >= 0) {
            int curNum = matrix[row][column];
            if (target == curNum) {
                return true;
            } else if (target < curNum) {
                column--; // target is less than curNum, decrease column to decrease curNum
            } else {
                row++; // target is greater than curNum, increase row to increase curNum
            }
        }
        return false;
    }
}