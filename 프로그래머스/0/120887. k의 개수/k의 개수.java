class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int idx = i ; idx <= j ; idx++){
            String s = String.valueOf(idx);
            
            for(char c : s.toCharArray()){
                if(Integer.parseInt(c+"") == k) answer++;
            }
            
        }
        return answer;
    }
}