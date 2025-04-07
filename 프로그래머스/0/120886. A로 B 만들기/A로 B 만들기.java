class Solution {
    public int solution(String before, String after) {
        StringBuilder sb = new StringBuilder(before);
        StringBuilder sb2 = new StringBuilder(after);
        
        for(int i = 0 ; i < sb.length() ; i++){
            int idx = sb2.indexOf(String.valueOf(sb.charAt(i)));
            if(idx != -1){
                sb2.delete(idx,idx+1);
                continue;
            }
            return 0;
        }
        return 1;
    }
}