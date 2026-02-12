import java.util.*;
class Solution {
    public String solution(int a, int b) {
        Map<Integer,Integer> map = new HashMap<>();
        String[] arr = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int day = 0;
        
        map.put(1,31);
        map.put(2,29);
        map.put(3,31);
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);
        
        for(int i = 1 ; i < a ; i ++){
            day += map.get(i);
        }
        
        day += b;
        day --;
        
        String answer = arr[day % 7];
        return answer;
    }
}