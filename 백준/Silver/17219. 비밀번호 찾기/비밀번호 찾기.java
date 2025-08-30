import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap();
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            
            map.put(st.nextToken(),st.nextToken());
            
        }
        
        for(int i = 0 ; i< m ; i++){
            sb.append(map.get(bf.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}