class Solution {
    public String solution(String s, int n) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char c : ch){
            if(c == ' ') sb.append(" ");
            else if (c >= 'a' && c <= 'z'){
                int nextC = c + n ;
                if(nextC > 'z') nextC -= 26;
                sb.append((char)nextC);
            } else {
                int nextC = c + n ;
                if(nextC > 'Z') nextC -= 26;
                sb.append((char)nextC);
            }
        }
        return sb.toString();
    }
}