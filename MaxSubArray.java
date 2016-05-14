// 53. Maximum Subarray
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}