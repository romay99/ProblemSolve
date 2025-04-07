import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        int maxValue = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i] , arr[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}
