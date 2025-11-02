import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(bf.readLine());
      int k = Integer.parseInt(bf.readLine());
      int[] arr = new int[n];
      
      StringTokenizer st = new StringTokenizer(bf.readLine());
      List<Integer> dist = new ArrayList();
      
      for(int i = 0 ; i < n ; i++){
          arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      for(int i = 0 ; i < n -1; i ++){
          dist.add(arr[i+1] - arr[i]); 
      }
      dist.sort((a,b) -> b-a);
      int result = 0 ;
      for(int i = k - 1 ; i < n - 1 ; i ++){
          result += dist.get(i);
      }
      System.out.println(result);
      
  }
}