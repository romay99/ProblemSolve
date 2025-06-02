class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        String str = x + "";
        
        for(int i = 0 ; i< str.length() ; i++){
            sum += Integer.parseInt(str.charAt(i) + "");
        }
        
        if(x % sum != 0) answer = false;
        return answer;
    }
}