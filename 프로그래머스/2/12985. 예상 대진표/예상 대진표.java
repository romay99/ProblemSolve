import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        while(true){
            answer++;
            
            if(min + 1 == max && min % 2 == 1){
                break;
            }
            
            if(min % 2 == 1){
                min /= 2;
                min ++;
            } else {
                min /= 2;
            }
            
            if(max % 2 == 1){
                max /= 2;
                max ++;
            } else {
                max /= 2;
            }
        }

        return answer;
    }
}