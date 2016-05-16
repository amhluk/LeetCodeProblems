// 152. Maximum Product Subarray 
public class Solution {
    public int maxProduct(int[] nums) {
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = minSoFar;
            minSoFar = Math.min(Math.min(nums[i], minSoFar * nums[i]), maxSoFar * nums[i]);
            maxSoFar = Math.max(Math.max(nums[i], temp * nums[i]), maxSoFar * nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}