import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][3];
        int[][] dp = new int[n][3];
        int[][] minDp = new int[n][3];

        for(int i = 0 ; i < n ; i ++){
            String[] split = bf.readLine().split(" ");
            map[i][0] = Integer.parseInt(split[0]);
            map[i][1] = Integer.parseInt(split[1]);
            map[i][2] = Integer.parseInt(split[2]);
        }
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];

        for(int i = 1 ; i < n ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2])+map[i][1];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2])+ map[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1]) + map[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0],minDp[i-1][1]),minDp[i-1][2])+map[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2])+ map[i][2];
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3 ; i++){
            max = Math.max(dp[n-1][i],max);
            min = Math.min(minDp[n-1][i],min);
        }
        System.out.println(max+" "+min);
    }
}