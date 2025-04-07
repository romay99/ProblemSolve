import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        st = new StringTokenizer(bf.readLine());
        
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : arr) {
            if (num > maxValue) {
                maxValue = num;
            }
            if (num < minValue) {
                minValue = num;
            }
        }
        System.out.println(minValue + " " + maxValue);
        
        
    }
}