import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int a : scoville){
            pq.offer(a);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            
            if(cur < K){
                if(pq.isEmpty()) return -1;
                
                pq.offer(cur + pq.poll() * 2);
                answer++;
            }
        }
        return answer;
    }
}