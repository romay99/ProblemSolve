import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                list.add(arr[i]);
                continue;
            }    
            if(stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
            list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size() ; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}