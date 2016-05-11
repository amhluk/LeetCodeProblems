// 239. Sliding Window Maximum
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // return empty array if nums is null or empty or k is larger than size of nums
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        // return array
        int ret[] = new int[nums.length - k + 1];
        
        Deque<Integer> Q = new LinkedList<Integer>();
        
        for (int i = 0; i < k; i ++) {
            while(!Q.isEmpty() && nums[i] >= nums[Q.getLast()]) {
                Q.removeLast();
            }
            Q.addLast(i);
        }
        
        for (int i = k; i < nums.length; i++) {
            ret[i - k] = nums[Q.getFirst()];
            while(!Q.isEmpty() && nums[i] >= nums[Q.getLast()]) {
                Q.removeLast();
            }
            while(!Q.isEmpty() && Q.getFirst() <= i - k) {
                Q.removeFirst();
            }
            Q.addLast(i);
        }
        
        ret[nums.length - k] = nums[Q.getFirst()];
        
        return ret;
    }
}