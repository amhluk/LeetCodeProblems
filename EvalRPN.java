// 150. Evaluate Reverse Polish Notation
public class Solution {
    private static final Set<String> Operations
      = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
      
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (Operations.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                switch(token) {
                    case "+": c = a + b;
                        break;
                    case "-": c = a - b;
                        break;
                    case "*": c = a * b;
                        break;
                    case "/": c = a / b;
                        break;
                    default: throw new IllegalArgumentException("Invalid token " + token);
                }
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}