import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        
        a[0] = 1;
        b[1] = 1;
        
        for(int i = 2 ; i <= n ; i++){
            a[i] = b[i-1];
            b[i] = b[i-1] + b[i-2];
        }
        System.out.println(a[n] + " " + b[n]);
    }
}