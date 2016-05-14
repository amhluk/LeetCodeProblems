// 20. Valid Parentheses
public class Solution {
    private static Map<Character, Character> map = 
        new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else if (stack.isEmpty() || map.get(stack.pop()) != cur) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}