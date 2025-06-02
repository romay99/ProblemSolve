class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int start = '0';
        int end = '9';
        
        if(s.length() == 4 || s.length() == 6){
            for(int i = 0 ; i < s.length() ; i ++){
                int now = s.charAt(i);
                if(now < start || now > end) return false;
            }
        } else {
            return false;
        }
        return answer;
    }
}