import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>> list = new ArrayList();
        int[] dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0 ;
        
        for(int i = 0 ; i <= N ; i ++){
            list.add(new ArrayList());
        }
        
        for(int[] r : road){
            list.get(r[0]).add(new Node(r[1],r[2]));
            list.get(r[1]).add(new Node(r[0],r[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            List<Node> nextList = list.get(cur.to);
            
            for(Node n : nextList){
                int nextCost = n.cost + dist[cur.to];
                
                if(nextCost < dist[n.to]){
                    dist[n.to] = nextCost;
                    pq.offer(new Node(n.to,n.cost));
                }
            }
        }
        for(int i = 1 ; i <= N ; i ++){
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
    class Node{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}