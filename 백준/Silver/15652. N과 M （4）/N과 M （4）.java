import java.io.*;
public class Main{
    static int n;
    static int m;
    static StringBuffer result = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        int[] arr = new int[n];
        for(int i = 1 ; i <= n ; i++){
            arr[i-1] = i ;
        }
        back(0,arr,new StringBuilder() , 0);
        System.out.println(result.toString());
    }
    static void back(int step,int[] arr,StringBuilder sb,int start){
        if(step == m){
            result.append(sb);
            result.append("\n");
            sb = new StringBuilder();
            return;
        }

        for(int i = start ; i < arr.length ; i++){
            sb.append(arr[i]).append(" ");
            back(step + 1, arr, sb, i);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}