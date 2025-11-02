import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    List<Node> list = new ArrayList();
    int result = 0 ;

    for(int i = 0 ; i < n ; i ++){
      int point = Integer.parseInt(bf.readLine());
      list.add(new Node(i,point));
    }
    list.sort((a,b) -> b.level - a.level);
    for(int i = 1 ; i < n ; i ++){
      Node cur = list.get(i);
      if(cur.point >= list.get(i-1).point){
        result += cur.point - list.get(i-1).point + 1;
        cur.point = list.get(i-1).point - 1;
      }
    }
    System.out.println(result);
  }
  static class Node{
    int level;
    int point;
    Node(int level,int point){
      this.level = level;
      this.point = point;
    }
  }
}