import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, (a,b) -> b.compareTo(a));
        
        String answer = "";
        for(String tmp : arr) answer += tmp;
        return answer;
    }
}