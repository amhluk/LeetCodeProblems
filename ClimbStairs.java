// 70. Climbing Stairs 
public class Solution {
    public int climbStairs(int n) {
        int p = 1;
        int q = 1;
        for (int i = 2; i <= n; i++) {
            int temp = p;
            p = q;
            q += temp;
        }
        return q;
    }
}