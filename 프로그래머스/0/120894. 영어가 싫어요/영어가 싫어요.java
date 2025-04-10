import java.util.*;

class Solution {
    public long solution(String numbers) {
        HashMap<String,String> map = new HashMap();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(String s : numbers.split("")){
            if(map.containsKey(sb.toString())){
                result.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }  
            sb.append(s);
        }
        result.append(map.get(sb.toString()));
        return Long.parseLong(result.toString());
    }
}