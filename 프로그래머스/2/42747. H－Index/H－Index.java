import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        for(int i = 1 ; i <= 10000 ; i++){
            boolean stop = true;
            int cnt = 0;
            for(int j = 0 ; j < citations.length ; j++){
                if(citations[j] >= i){
                    cnt++;
                }
                if(cnt == i){
                    stop = false;
                }
            }
            if(stop){
                return i -1;
            }
        }
        return 0;
    }
}