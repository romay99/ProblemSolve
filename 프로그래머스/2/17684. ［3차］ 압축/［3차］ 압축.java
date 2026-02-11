import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int i = 1;
        
        for(; i <= 26 ; i ++){
            map.put(String.valueOf((char)('A' + (i - 1))), i);
        }
        
        int left = 0;
        int right = 1;
        int prev = 0;
        
        while(left < msg.length()){
            String make = msg.substring(left,right);
            
            if(map.containsKey(make)){
                if(right + 1 <= msg.length()){
                    right ++;
                } else {
                    list.add(map.get(make));
                    break;
                }
                prev = map.get(make);
            } else {
                map.put(make, i ++);
                list.add(prev);
                left = right - 1;
            }
        } 
        
        int[] answer = new int[list.size()];
        for(int j = 0 ; j < list.size() ; j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}