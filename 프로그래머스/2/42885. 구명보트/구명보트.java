import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList();
        Arrays.sort(people);
        for(int a : people) q.offer(a);
        
        while(!q.isEmpty()){
            int sum = 0;
            int max = q.pollLast();
            sum += max;
            
            if(!q.isEmpty() && sum + q.peekFirst() <= limit){
                sum += q.pollFirst();
            }

            answer++;
        }
        
        return answer;
    }
}