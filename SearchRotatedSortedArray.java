// 33. Search in Rotated Sorted Array
public class Solution {
    public int search(int[] nums, int target) {
        int L = 0; int R = nums.length - 1;
        while (L <= R) {
            int M = L + (R - L)/2;
            if (nums[M] == target) {
                return M;
            } 
            if (nums[M] >= nums[L]) { // mid is larger of equal to left
                if (nums[L] <= target && target < nums[M]) { // check left of mid
                    R = M - 1;
                } else { // check right of mid
                    L = M + 1;
                }
            } else { // mid is smaller than left
                if (nums[R] >= target && target > nums[M]) { // check right of mid
                    L = M + 1;
                } else { // check left of mid
                    R = M - 1;
                }
            }
        }
        return -1; // not found otherwise
    }
}