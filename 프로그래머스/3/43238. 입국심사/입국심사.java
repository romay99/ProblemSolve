import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length - 1] * (long)n;
        long mid = left + (right - left) / 2;
        long result = Long.MAX_VALUE;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(check(mid,times,n)){
                result = Math.min(result,mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    boolean check(long mid, int[] times,int n){
        long answer = 0;
        
        for(int i = 0 ; i < times.length ; i++){
            answer += mid / times[i];
        }
        if(answer >= n) return true;
        return false;
        
    }
}