import java.util.*;
class Solution {
    public long solution(long n) {
        String answer = "";
        List<Integer> list = new ArrayList();
        String tmp = n + "";
        String[] arr = tmp.split("");
        
        for(int i = 0 ; i < arr.length ; i ++){
            list.add(Integer.parseInt(arr[i]));
        }
        
        list.sort((a,b) -> b - a);
        
        for(int i = 0 ; i < list.size() ; i++){
            answer += list.get(i);
        }
        
        return Long.parseLong(answer);
    }
}