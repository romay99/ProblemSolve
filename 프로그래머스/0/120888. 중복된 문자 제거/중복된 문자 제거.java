import java.util.*;
class Solution {
    public String solution(String my_string) {
        List<Character> list = new ArrayList();
        
        String answer = "";
        for(char c : my_string.toCharArray()){
            if(!list.contains(c)) list.add(c);
        }
        for(int i = 0 ; i < list.size() ; i ++){
            answer += list.get(i);
        }
        return answer;
    }
}