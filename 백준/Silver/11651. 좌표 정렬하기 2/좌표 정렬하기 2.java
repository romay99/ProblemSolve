import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.y == b.y) return a.x - b.x;
            return a.y - b.y;
        });
        
        for(int i = 0 ;  i < n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }
        System.out.println(sb);
    }
}
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}