import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int z = 0 ; z < n ; z ++ ){
            int m = Integer.parseInt(bf.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            int result = 1;
            
            for(int i = 0; i < m ; i ++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                
                String tmp = st.nextToken();
                String key = st.nextToken();
                
                map.put(key, map.getOrDefault(key,0) + 1);
            }
            
            for(int cnt : map.values()){
                result *= cnt + 1;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.print(sb.toString());
    }
}