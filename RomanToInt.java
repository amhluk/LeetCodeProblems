// 13. Roman to Integer 
public class Solution {
    private static Map<Character, Integer> map
      = new HashMap<Character, Integer>() {{
         put('I', 1);
         put('V', 5);
         put('X', 10);
         put('L', 50);
         put('C', 100);
         put('D', 500);
         put('M', 1000);
      }};
    public int romanToInt(String s) {
        int prev = 0;
        int ret = 0;
        for(int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            ret += (cur > prev)? cur - 2*prev : cur;
            prev = cur;
        }
        return ret;
    }
}