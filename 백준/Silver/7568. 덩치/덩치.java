import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Node> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        
        for(int i = 0 ; i < list.size(); i++){
            Node now = list.get(i);
            int num = 1;
            for(int j = 0 ; j < list.size() ; j++){
                if(i == j ) continue;
                
                Node target = list.get(j);
                
                if(now.x < target.x && now.y < target.y){
                    num ++;
                }
            }
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
    class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }