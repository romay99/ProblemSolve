import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> cntMap = new HashMap();
        HashMap<String,PriorityQueue<Node>> map = new HashMap();
        PriorityQueue<Gen> genPQ = new PriorityQueue<>((a,b) -> b.cnt - a.cnt);
        List<Integer> list = new ArrayList();
        
        for(int i = 0 ; i < plays.length ; i++){
            Node node = new Node(i,genres[i],plays[i]);
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.play - a.play);
            
            cntMap.put(node.g , cntMap.getOrDefault(node.g,0) + node.play);
            
            if(map.containsKey(node.g)){
                pq = map.get(node.g);
                pq.add(node);
                map.put(node.g, pq);
                
            } else {
                pq.add(node);
                map.put(node.g, pq);
            }
        }
        
        for(String g : cntMap.keySet()){
            genPQ.add(new Gen(g,cntMap.get(g)));
        }
        
        while(!genPQ.isEmpty()){
            Gen now = genPQ.poll();
            
            PriorityQueue<Node> pq = map.get(now.gen);
            list.add(pq.poll().idx);
            
            if(!pq.isEmpty()) list.add(pq.poll().idx);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
class Node{
    int idx;
    String g;
    int play;
    Node(int idx , String g,int play){
        this.idx = idx;
        this.g = g;
        this.play = play;
    }
}
class Gen {
    String gen;
    int cnt;
    Gen(String gen , int cnt){
        this.gen = gen;
        this.cnt = cnt;
    }
}

