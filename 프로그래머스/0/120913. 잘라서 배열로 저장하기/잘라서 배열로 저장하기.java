import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList();
        
        int idx = 0;
        for(String s : my_str.split("")){
            if(n == idx){
                list.add(sb.toString());
                sb = new StringBuilder();
                idx = 0;
            }
            sb.append(s);
            idx ++;            
        }
        if(sb.length() > 0) list.add(sb.toString());
        
    
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i ++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}