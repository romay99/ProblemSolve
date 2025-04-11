import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Process> pq = new PriorityQueue<>((a,b) -> b.p - a.p);
        Queue<Process> q = new LinkedList();
        
        int[] result = new int[priorities.length];
        
        for(int i = 0 ; i < priorities.length ; i++){
            pq.offer(new Process(i,priorities[i]));
            q.offer(new Process(i,priorities[i]));
        }
        
        int num = 1;
        while(!pq.isEmpty()){
            Process p = pq.poll();
            while(p.p != q.peek().p){
                q.offer(q.poll());
            }
            Process now = q.poll();
            result[now.idx] = num++;
        }
        
        return result[location];
    }
}
class Process{
    int idx;
    int p;
    
    Process(int idx , int p){
        this.idx = idx;
        this.p = p;
    }
}