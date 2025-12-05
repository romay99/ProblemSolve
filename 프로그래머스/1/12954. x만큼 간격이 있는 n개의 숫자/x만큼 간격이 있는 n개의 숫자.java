import java.util.*;
class Solution {
    public long[] solution(long x, int n) {
        List<Long> list = new ArrayList();
        
        for(int i = 0 ; i < n ; i++){
            Long newX = x + x*i;
            list.add(newX);
        }
        long[] answer = new long[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);    
        }
        return answer;
    }
}