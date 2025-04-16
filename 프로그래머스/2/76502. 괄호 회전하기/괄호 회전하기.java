import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            if(check(i,s)) answer++;
        }
        return answer;
    }
    
    boolean check(int start, String s){
        Stack<Character> stack = new Stack();
        if(s.length() % 2 == 1) return false;
        
        for(int i = 0 ; i < s.length() ; i ++){
            int idx =  ( i + start ) % s.length();
            
            char c = s.charAt(idx);
            if(c == '[' || c =='{' || c=='(') stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (c == ']') {
                if(stack.pop() != '[') return false;
            } else if (c == '}'){
                if(stack.pop() != '{') return false;
            } else if (c == ')') {
                if(stack.pop() != '(') return false;
            }
        }
        return true;
        
    }
}