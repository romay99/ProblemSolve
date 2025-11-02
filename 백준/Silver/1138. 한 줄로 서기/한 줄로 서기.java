import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(bf.readLine());
      List<Node> list = new ArrayList();
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for(int i = 0 ; i < n ; i++){
          list.add(new Node(i + 1,Integer.parseInt(st.nextToken())));
      }
      list.sort((a,b) -> b.h - a.h);
      
      LinkedList<Node> link = new LinkedList<>();
      for(int i = 0 ; i < list.size() ; i++){
          Node cur = list.get(i);
          if(link.size() == cur.people){
              link.add(cur);
          } else {
              link.add(cur.people,cur);
          }
      }
      String result = "";
      for(Node node : link){
          result += node.h;
          result += " ";
      }
      result = result.substring(0,result.length() - 1);
      System.out.println(result);
      
      
  }
    static class Node{
        int h;
        int people;
        Node(int h , int people){
            this.h = h;
            this.people = people;
        }
    }
}