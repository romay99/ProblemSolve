import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i ++) arr[i] = Integer.parseInt(st.nextToken());
        
        int result = 0 ;
        int left = 0 ;
        for(int i = 0 ; i < n ; i++){
            int now = arr[i];
            map.put(now , map.getOrDefault(now,0) + 1);
            
            while(map.size() > 2){
                map.put(arr[left] , map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            int max = i - left;
            result = Math.max(result,max);
        }
        System.out.println(result + 1);
    }
}