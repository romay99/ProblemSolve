import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        List<List<String>> list = new ArrayList();
        List<String> dup = new ArrayList();
        
        for(int i = 0 ; i < n ; i ++){
            list.add(new ArrayList());
        }
        
        int turn = 0;
        for(int i = 0 ; i < words.length ; i++){
            if(turn == n) turn = 0 ;
            String now = words[i];
            List<String> player = list.get(turn);
            
            if(dup.size() >= 1){
                String past = dup.get(i-1);
                if(past.charAt(past.length()-1) != now.charAt(0)){
                    return new int[]{turn + 1,player.size()+1};
                }
            }
            if(dup.contains(now)) return new int[]{turn + 1,player.size() + 1};
            player.add(now);
            dup.add(now);
            turn ++;
        }

        return new int[]{0,0};
    }
}