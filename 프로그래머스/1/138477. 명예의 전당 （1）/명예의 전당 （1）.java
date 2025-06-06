import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        
        for(int i = 0 ; i < score.length ; i++){
            if(pq.size() == k){
                pq.add(score[i]);
                pq.poll();
            } else {
                pq.add(score[i]);
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}