import java.util.*;
class Solution {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;

        for(int i = 0 ; i < dartResult.length() ; i++){
            char c = dartResult.charAt(i);

            if(c >= '0' && c <= '9'){
                int num = Integer.parseInt(String.valueOf(c));
                if(dartResult.charAt(i+1) == '0') {
                    num = 10;
                    i++;
                }
                char nextC = dartResult.charAt(i+1);
                if(nextC == 'S'){
                    stack.push(num);
                } else if(nextC == 'D'){
                    stack.push(num * num);
                } else if(nextC == 'T'){
                    stack.push(num * num * num);
                }
            }
            if(c == '*'){
                int past = stack.pop();
                if(!stack.isEmpty()){
                    stack.push(stack.pop()*2);
                }
                stack.push(past * 2);
            }
            if(c =='#'){
                stack.push(stack.pop() * -1);
            }
        }

        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        return answer;
    }
}