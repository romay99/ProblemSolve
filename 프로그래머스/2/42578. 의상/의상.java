import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap();
        
        for(String[] s : clothes){
            String key = s[1];
            map.put(key, map.getOrDefault(key , 0 ) + 1);
        }
        
        for(int a : map.values()){
            answer *= (a + 1);
        }
        
        return answer -1;
    }
}