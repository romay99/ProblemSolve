import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            String now = String.valueOf(s.charAt(i));
            if(stack.empty()) {
                stack.push(now);
                continue;
            }
            String compare = stack.peek();

            if(compare.equals("(") && now.equals(")")) {
                stack.pop();
                continue;
            }
            stack.push(now);
        }

        return stack.isEmpty();
    }
}