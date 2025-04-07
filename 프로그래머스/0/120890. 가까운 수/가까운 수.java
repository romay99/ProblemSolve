import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        Arrays.sort(array);
        
        for(int a : array){
            int nowGap = Math.abs(a - n);
            
            if(nowGap < gap){
                gap = nowGap;
                answer = a;
                System.out.println(nowGap);
            }
        }
        
        return answer;
    }
}