import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap();
        for(String s : completion){
            map.put(s , map.getOrDefault(s,0) + 1);
        }
        
        for(String s : participant){
            if(!map.containsKey(s)) return s;
            if(map.get(s) > 0){
                map.put(s,map.get(s) - 1);
            } else {
                return s;
            }
        }
        return answer;
    }
}