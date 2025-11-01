import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->a-b);
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            pq.offer(Integer.parseInt(bf.readLine()));
        }
        while(!pq.isEmpty()){
            int now = pq.poll();
            
            if(pq.isEmpty()){
                System.out.println(result);
                break;
            }
            int next = pq.poll();
            pq.offer(now + next);
            result += now+next;
        }
    }
}