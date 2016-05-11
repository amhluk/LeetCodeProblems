// 35. Search Insert Position
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int M = (L + R)/2;
            if (nums[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (nums[L] < target)? L + 1 : L;
    }
}