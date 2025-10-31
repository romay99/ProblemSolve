import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes , (a,b) -> a[1] - b[1]);
        int answer = 1;
        int nowC = routes[0][1];
        
        for(int i = 0 ; i < routes.length ; i++){
            int[] cur = routes[i];
            if(nowC >= cur[0]){
                continue;
            }
            answer ++;
            nowC = cur[1];
        }
        return answer;
    }
}