import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        Integer[][] dp = new Integer[2][41];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(bf.readLine());
            sb.append(dp[0][index]).append(" ").append(dp[1][index]).append("\n");
        }
        System.out.print(sb);
    }
}