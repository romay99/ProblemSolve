class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 1){
            return s.charAt(s.length()/2) + "";
        }
        
        return s.substring(s.length()/2 - 1,s.length()/2 + 1);
    }
}