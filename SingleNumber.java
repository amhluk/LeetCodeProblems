// 136. Single Number
public class Solution {
    public int singleNumber(int[] nums) {
        /* USING SET
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.iterator().next(); */
        
        /* USING XOR */
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}