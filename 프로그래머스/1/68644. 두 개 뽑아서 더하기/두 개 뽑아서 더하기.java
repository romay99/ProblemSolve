import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < numbers.length - 1 ; i++){
            for(int j = i+1 ; j < numbers.length ; j++){
                int cur = numbers[i] + numbers[j];
                if(!list.contains(cur)) list.add(cur);
            }
        }
        list.sort((a,b) -> a-b);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}