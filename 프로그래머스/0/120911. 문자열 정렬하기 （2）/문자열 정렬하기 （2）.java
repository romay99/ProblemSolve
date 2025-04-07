import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        
        char[] c = my_string.toCharArray();
        Arrays.sort(c);
        
        for(char ch : c){
            answer += ch;
        }
        
        return answer;
    }
}