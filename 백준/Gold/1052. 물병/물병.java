import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int result = 0;
      while(Integer.bitCount(n) > k){
          n++;
          result ++;
      }
      System.out.println(result);
  }
}