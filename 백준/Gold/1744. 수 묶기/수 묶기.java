import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> mq = new PriorityQueue<>((a,b) ->a - b);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->b - a);
        PriorityQueue<Integer> zq = new PriorityQueue<>((a,b) ->b - a);
        int n = Integer.parseInt(bf.readLine());
        
        for(int i = 0 ; i < n ; i ++){
            int input = Integer.parseInt(bf.readLine());
            if(input == 0) zq.offer(0);
            else if (input > 0) pq.offer(input);
            else mq.offer(input);
        }
        int result = 0 ;
        while(!mq.isEmpty()){
            int now = mq.poll();
            if(!mq.isEmpty()){
                result += now * mq.poll();
            } else {
                if(!zq.isEmpty()){
                    zq.poll();
                } else {
                    result += now;
                }
            }
        }
        while(!pq.isEmpty()){
            int now = pq.poll();
            if(!pq.isEmpty()){
                if(pq.peek() == 1){
                    result += now;
                    continue;
                }
                result += now * pq.poll();
            } else {
                result += now;
            }
        }
        
        System.out.println(result);
    }
}