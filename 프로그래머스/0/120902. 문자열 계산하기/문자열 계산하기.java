import java.util.*;
class Solution {
    public int solution(String my_string) {
        Stack<String> stack = new Stack();
        String[] arr = my_string.split(" ");
        int answer = Integer.parseInt(arr[0]);
        
        for(int i = 1 ; i < arr.length ; i++){
            String now = arr[i];
            
            if(!now.equals("+") && !now.equals("-")){
                String c = stack.pop();
                if(c.equals("+")) answer += Integer.parseInt(now);
                else answer -= Integer.parseInt(now);
            } else {
                stack.push(now);
            }
        }
        return answer;
    }
}