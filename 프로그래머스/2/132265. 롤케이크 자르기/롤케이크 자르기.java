import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        int answer = 0;
        
        
        for(int i = 0 ; i < topping.length ; i++){
            int now = topping[i];
            
            right.put(now,right.getOrDefault(now,0) + 1);
        }
        
        for(int i = 0 ; i < topping.length ; i++){
            int now = topping[i];
            int rightCnt = right.get(now);
            
            left.put(now, left.getOrDefault(now,0) + 1);
            
            if(rightCnt - 1 == 0){
                right.remove(now);
            } else {
                right.put(now,rightCnt - 1);
            }
            
            if(left.size() == right.size()){
                answer ++;
            }
        }
        
        return answer;
    }
}