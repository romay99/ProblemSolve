import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < number.length() ; i++){
            int now = Integer.parseInt(number.charAt(i) + "");
            if(stack.isEmpty()) {
                stack.push(now);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() < now && k > 0){
                k--;
                stack.pop();
            }
            if(stack.size() < number.length() - k){
                stack.push(now);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}