import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet();
        Arrays.sort(phone_book);
        
        for(int i = phone_book.length - 1 ; i >= 0  ; i--){
            String now = phone_book[i];
            
            if(set.contains(now)) return false;
            
            for(int j = 1 ; j < now.length() + 1 ; j ++){
                set.add(now.substring(0,j));
            }
        }
        boolean answer = true;
        return answer;
    }
}