import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList();
        Queue<Node> q = new LinkedList();
        for(int i = 0 ; i < speeds.length ; i++){
            q.offer(new Node(progresses[i],speeds[i]));
        }
        
        int day = 1;
        while(!q.isEmpty()){
            int cnt = 0 ;
            Node cur = q.peek();
            if(cur.p + cur.s * day >= 100){
                cnt++;
                q.poll();
                
                while(!q.isEmpty() && q.peek().p + q.peek().s * day >= 100){
                    cnt++;
                    q.poll();
                }
            } 
            if(cnt >= 1) list.add(cnt);
            day++;
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
class Node{
    int p;
    int s;
    
    Node(int p , int s){
        this.p = p;
        this.s = s;
    }
}