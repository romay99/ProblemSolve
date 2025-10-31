import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(bf.readLine(),"-");
    int answer = Integer.MAX_VALUE;

    while(str.hasMoreTokens()){
      int now = 0;
      StringTokenizer str2 = new StringTokenizer(str.nextToken(),"+");
      while(str2.hasMoreTokens()){
        now += Integer.parseInt(str2.nextToken());
      }
      if (answer == Integer.MAX_VALUE) {
        answer = now;
        continue;
      }
      answer -= now;
    }
    System.out.println(answer);

  }
}
