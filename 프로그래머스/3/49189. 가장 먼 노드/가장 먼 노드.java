import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxValue = Integer.MIN_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0 ;
        
        List<List<Integer>> list = new ArrayList();
        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList());
        }
        
        for(int[] e : edge){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            List<Integer> nextList = list.get(cur.to);
            
            for(int next : nextList){
                if(cur.cost + 1 < dist[next]){
                    maxValue = Math.max(maxValue,cur.cost + 1);
                    dist[next] = cur.cost + 1;
                    pq.offer(new Node(next,cur.cost+1));
                }
            }
        }
        for(int i = 1 ; i < dist.length ; i++){
            if(dist[i] == maxValue) answer++;
        }
        
        
        return answer;
    }
    class Node{
        int to;
        int cost;
        Node(int to,int cost){
            this.to=to;
            this.cost =cost;
        }
    }
}