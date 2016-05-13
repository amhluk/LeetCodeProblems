// 154. Find Minimum in Rotated Sorted Array II
public class Solution {
    public int findMin(int[] nums) {
        int L = 0; int R = nums.length - 1;
        while (L < R && nums[L] >= nums[R]) {
            int M = L + (R - L) / 2;
            if (nums[M] > nums[R]) {
                L = M + 1;
            } else if (nums[M] < nums[R]) {
                R = M;
            } else {
                L = L + 1;
            }
        }
        return nums[L];
    }
}