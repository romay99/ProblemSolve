import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int [n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = 0;
        for (int i = 1; i < n; i++) { // i 가 기준수
            for (int j = 0; j < i; j++) { // j 가 i 보다 작은 여러 수
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}




