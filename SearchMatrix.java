// 74. Search a 2D Matrix
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // check for non-zero dimensions
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        // get dimensions
        int M = matrix.length;
        int N = matrix[0].length;
        
        // skip if target is less than min or greater than max
        if (target < matrix[0][0] || target > matrix[M-1][N-1]) {
            return false;
        }
        
        // binary search for row
        int low = 0;
        int high = M - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        //binary search for col
        int row = high;
        low = 0;
        high = N - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}