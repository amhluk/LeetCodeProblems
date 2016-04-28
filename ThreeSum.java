// 15. 3Sum
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums); // sort nums
        
        List<List<Integer>> ret = new ArrayList<>(); // initialize array list
        
        for (int i = 0; i < nums.length - 2; i++) { // iterate through nums
            if (i > 0 && nums[i] == nums[i - 1]) { // skip duplicates
                continue;
            }
            // iterate through rest of nums from both ends
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) { // if ends cross stop
                if (j > i + 1 && nums[j] == nums[j - 1]) { // skip duplicates
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k]; // calculate sum
                if (sum == 0) { // if sum is 0, add to list and update j and k
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) { // sum is less than 0, so increment j for a larger sum
                    j++;
                } else { // sum is greater than 0, so decrement k for a smaller sum
                    k--;
                }
            }
        }
        
        return ret;
    }
}