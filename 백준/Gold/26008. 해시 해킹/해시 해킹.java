import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int h = Integer.parseInt(st.nextToken());

        long result = 1;
        for (int i = 0; i < n - 1 ; i++) {
            result *= m;
            result %= 1000000007;
        }
        System.out.println(result);
    }
}