import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<Node>> list =new ArrayList();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost- b.cost);
        for(int i = 0 ; i <= n ; i ++){
            list.add(new ArrayList());
        }
        
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.get(s).add(new Node(e,c));
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        pq.offer(new Node(s,0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost > dist[cur.to]) continue;
            List<Node> next = list.get(cur.to);
            
            for(Node ne : next){
                if(dist[cur.to] + ne.cost < dist[ne.to] ){
                    dist[ne.to] = dist[cur.to] + ne.cost;
                    pq.offer(new Node(ne.to,dist[ne.to]));
                }
            }
        }
        System.out.println(dist[e]);
    }
    static class Node{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}