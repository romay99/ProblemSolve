import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Long> dist = new ArrayList();
        long[] cost = new long[n+1]; 
        Long minValue = Long.MAX_VALUE;
        boolean checkMin = false;
        Long result = 0L;
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        while(st.hasMoreTokens()){
            dist.add(Long.parseLong(st.nextToken()));    
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 1 ; i <= n ; i ++){
            cost[i] = Long.parseLong(st.nextToken());
            if(cost[i] < minValue) minValue = cost[i];
        }
        
        
        for(int i = 1  ; i <= n - 1 ; i++){
            if(cost[i] == minValue) checkMin = true;
            
            if(checkMin){
                result += minValue * dist.get(i-1);
            } else {
                result += cost[i] * dist.get(i-1);
            }
        }
        System.out.println(result);
        
    }
}