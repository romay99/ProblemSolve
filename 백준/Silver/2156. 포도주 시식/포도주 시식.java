import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for(int i = 1 ; i <= n ; i ++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        if(n == 1){
            System.out.println(arr[1]);
            return;
        } else if (n == 2){
            System.out.println(arr[1] + arr[2]);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i = 3 ; i <= n ; i ++){
            dp[i] = Math.max(
                dp[i-1],
                Math.max(arr[i] + dp[i-2] , arr[i]+arr[i-1] +dp[i-3])
            );
        }
        System.out.println(dp[n]);
        
    }
}