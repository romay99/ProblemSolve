import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> del = new ArrayList();
        for(int a : delete_list){
            del.add(a);
        }
        List<Integer> result = new ArrayList();
        for(int a : arr ){
            if(!del.contains(a)){
                result.add(a);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}