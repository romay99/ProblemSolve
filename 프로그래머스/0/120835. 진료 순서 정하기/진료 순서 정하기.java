import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        List<Node> list = new ArrayList();
        for(int i = 0 ; i < emergency.length ; i++){
            list.add(new Node(i+1,emergency[i]));
        }
        list.sort((a,b) -> b.p - a.p);
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            Node node = list.get(i);
            answer[node.idx-1] = i+1;
        }
        
        return answer;
    }
}
class Node {
    int idx;
    int p;
    
    Node(int idx,int p){
        this.idx = idx;
        this.p = p;
    }
}