import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int idx = 0 ;
        for(String s : quiz){
            String[] arr = s.split(" ");
            int one = Integer.parseInt(arr[0]);
            int two = Integer.parseInt(arr[2]);
            int three = Integer.parseInt(arr[4]);
            
            String value = "";
            
            if("+".equals(arr[1])){
                if(one + two == three){
                    value = "O";
                } else {
                    value = "X";
                }
            } else {
                if(one - two == three){
                    value = "O";
                } else {
                    value = "X";
                }
            }
            
            answer[idx++] = value;
        }
        return answer;
    }
}