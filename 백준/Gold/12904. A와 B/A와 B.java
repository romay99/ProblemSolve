import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    String t = bf.readLine();
    HashSet<String> set = new HashSet<>();

    Queue<StringBuilder> q = new LinkedList();
    q.offer(new StringBuilder(t));

    while(!q.isEmpty()){
        StringBuilder sb = q.poll();
        StringBuilder next1;
        StringBuilder next2;
        
        if(sb.charAt(sb.length()-1)=='A'){
            next1 = new StringBuilder(sb.deleteCharAt(sb.length()-1));
            if(next1.toString().equals(s)){
                System.out.println(1);
                return;
            }
            if(next1.length() > s.length()){
                q.offer(next1);
            }
        } else {
            next2 = new StringBuilder(sb.deleteCharAt(sb.length()-1).reverse());
            if(next2.toString().equals(s)){
                System.out.println(1);
                return;
            }
            if(next2.length() > s.length()){
                q.offer(next2);
            }
        }

    }
    System.out.println(0);

  }
}