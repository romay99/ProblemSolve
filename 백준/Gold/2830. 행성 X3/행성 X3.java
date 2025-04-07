import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] bit = new int[20];
        long result = 0L ;

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int nowNum = Integer.parseInt(bf.readLine());
            int idx = 0 ;
            while (nowNum > 0) {
                bit[idx] += nowNum % 2; // 한자리 비트씩 배열에 추가
                nowNum /= 2;
                idx++;
            }
        }
        for (int i = 0 ; i < bit.length ; i++) {
            result += (long) Math.pow(2, i) * bit[i] * (n - bit[i]);
        }
        System.out.println(result);
    }
}