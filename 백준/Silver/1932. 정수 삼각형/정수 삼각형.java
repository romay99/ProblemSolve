import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n + 1][n + 1];
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 ) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
                }
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        System.out.println(maxValue);
    }
}