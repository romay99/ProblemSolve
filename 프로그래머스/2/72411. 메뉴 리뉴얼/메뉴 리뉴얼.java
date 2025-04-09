import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList();
        List<String> result = new ArrayList();
        HashMap<String,Integer> map = new HashMap();
        
        for(String s : orders){
            getCom(list,new boolean[s.length()],0,"",s,0);
        }
        
        for(String s : list){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        
        for(int i = 0 ; i < course.length ;  i++){
            int count = course[i];
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.cnt - a.cnt);
            
            for(String s : map.keySet()){
                if(s.length() == count && map.get(s) >= 2){
                    pq.add(new Node(s,map.get(s)));
                }
            }
            
            if(!pq.isEmpty()){
                int max = pq.peek().cnt;
            
                while(!pq.isEmpty() && pq.peek().cnt == max){
                    result.add(pq.poll().s);
                }
            }
        }
        result.sort((a,b) -> a.compareTo(b));
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < result.size() ; i ++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    void getCom(List<String> list , boolean[] visited , int cnt,String s, String og,int start){
        if(cnt >= 2 ) {
            String[] tmp = s.split("");
            Arrays.sort(tmp);
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < tmp.length ; i++){
                sb.append(tmp[i]);
            }
            list.add(sb.toString());
          }
        
        for(int i = start ; i < og.length() ; i ++){
            if(!visited[i]){
                visited[i] = true;
                getCom(list,visited,cnt + 1, s + og.charAt(i) , og, i);
                visited[i] = false;
            }
        }
    }
}
class Node {
    String s;
    int cnt;
    
    Node(String s , int cnt){
        this.s = s;
        this.cnt = cnt;
    }
}

