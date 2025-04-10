import java.util.*;
class Solution {
    public int solution(int n) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int value = 1;
        for(int i = 1 ; i <= 100 ; i++){
            String s = String.valueOf(value);
            
            while(value % 3 == 0 || s.contains("3")) {
                value++;
                s = String.valueOf(value);
                }
            
            map.put(i,value++);
        }
        return map.get(n);
    }
}