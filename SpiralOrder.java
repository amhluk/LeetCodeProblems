// 54. Spiral Matrix
public class Solution {
   
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = -1;
        for(;;) {
            // right
            for (int i = 0; i < n; i++) {
                list.add(matrix[row][++col]);
            }
            if (--m == 0) {
                break;
            }
            
            // down
            for (int j = 0; j < m; j++) {
                list.add(matrix[++row][col]);
            }
            if (--n == 0) {
                break;
            }
            
            //left
            for (int i = 0; i < n; i++) {
                list.add(matrix[row][--col]);
            }
            if (--m == 0) {
                break;
            }
            
            // up
            for (int j = 0; j < m; j++) {
                list.add(matrix[--row][col]);
            }
            if (--n == 0) {
                break;
            }
        }
        return list;
    }
}