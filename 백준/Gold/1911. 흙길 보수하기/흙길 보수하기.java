import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        list.sort((a,b) -> a.start - b.start);

        int nowStart = list.get(0).start;
        int nowEnd = nowStart;
        int cnt = 0;

        for(Node cur : list){
            if(cur.start > nowEnd){
                nowEnd = cur.start;
            }
            while(cur.end > nowEnd){
                cnt ++;
                nowEnd += l;
            }
        }
        System.out.println(cnt);
    }
    static class Node{
        int start;
        int end;
        Node(int start , int end){
            this.start = start;
            this.end = end;
        }
    }
}