// 153. Find Minimum in Rotated Sorted Array 
public class Solution {
    public int findMin(int[] nums) {
        int L = 0; int R = nums.length - 1;
        while (L < R && nums[L] >= nums[R]) {
            int M = L + (R - L) / 2;
            if (nums[M] > nums[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return nums[L];
    }
}