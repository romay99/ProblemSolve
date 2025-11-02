import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList();
        int n = Integer.parseInt(bf.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.v - a.v);
        int result = 0;
        for(int i = 0 ; i < n ; i ++){
            list.add(bf.readLine());
        }
        for(String s : list){
            int idx = 1; // 10의 자리 곱셈
            for(int i = s.length() - 1 ; i >= 0 ; i --){
                char c = s.charAt(i);
                idx *= 10;
                map.put(c,map.getOrDefault(c,0) + idx);
            }
        }
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.offer(new Node(e.getKey(),e.getValue()));
        }
        int num = 9;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            map.put(cur.ch , num);
            num --;
        }
        
        for(String s : list ){
            String sum = "";
            for(int i = 0 ; i < s.length() ; i++){
                sum += String.valueOf(map.get(s.charAt(i)));
            }
            result += Integer.parseInt(sum);
        }
        System.out.println(result);
    }
    static class Node {
        char ch;
        int v;
        Node(char ch , int v){
            this.ch = ch;
            this.v = v;
        }
    }
}