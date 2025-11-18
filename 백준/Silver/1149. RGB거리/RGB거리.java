import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n+1][3];
        int[][] map = new int[n+1][3];
        
        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0 ; j < 3 ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][0] = map[1][0];
        dp[1][1] = map[1][1];
        dp[1][2] = map[1][2];
        
        for(int i = 2 ; i <= n ; i ++ ){
            for(int j = 0 ; j < 3 ; j++){
                if(j == 0 ){
                    dp[i][j] = Math.min(dp[i-1][1],dp[i-1][2]) + map[i][j];
                } else if( j == 1){
                    dp[i][j] = Math.min(dp[i-1][0],dp[i-1][2]) + map[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][1],dp[i-1][0]) + map[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3 ; i ++){
            result = Math.min(dp[n][i],result);            
        }
        System.out.println(result);
    }
}