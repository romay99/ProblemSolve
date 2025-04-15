import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack();
        stack.push(new Node(0,prices[0]));
        
        for(int i = 1 ; i < prices.length ; i++){
            Node node = new Node(i,prices[i]);
            
            while(!stack.isEmpty() && stack.peek().p > prices[i]){
                Node s = stack.pop();
                answer[s.idx] = i-s.idx;
            }
            stack.push(node);
        }
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            answer[node.idx] = prices.length -1 - node.idx;
        }
        return answer;
    }
}
class Node {
    int idx;
    int p;
    Node(int idx, int p){
        this.idx = idx;
        this.p = p;
        
    }
}