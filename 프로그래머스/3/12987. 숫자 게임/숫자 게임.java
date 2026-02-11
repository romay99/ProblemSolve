import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int min = 0;
        int max = B.length - 1;
        for(int i = A.length - 1 ; i >= 0  ; i--){
            if(A[i] < B[max]){ // A[i] = A 쪽 제일 큰수
                max --;
                answer ++;
            } else {
                min++;
            } 
        }
        return answer;
    }
}