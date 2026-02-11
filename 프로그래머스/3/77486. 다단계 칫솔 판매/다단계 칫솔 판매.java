import java.util.*;
class Solution {
    static Map<String, String> p = new HashMap<>(); // 부모
    static Map<String, Integer> profit = new HashMap<>(); // 수익
    static List<String> list = new ArrayList<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        profit.put("-" , 0);
        
        for(int i = 0 ; i < enroll.length ; i++){
            String name = enroll[i];
            String pa = referral[i];
            
            p.put(name,pa);
            profit.put(name,0);
            list.add(name);
        }
        
        for(int i = 0 ; i < seller.length ; i ++){
            String sell = seller[i];
            int cnt = amount[i];
            
            count(cnt * 100 , sell);
        }

        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = profit.get(list.get(i));            
        }
        
        return answer;
    }
    
    static void count(int amount, String name){
        if(amount < 10 || name.equals("-")){
            profit.put(name, profit.get(name) + amount);
            return ;
        }
        
        int tmp = amount / 10;
        
        profit.put(name, profit.get(name) + (amount - tmp));
        count(tmp , p.get(name));
    }
}