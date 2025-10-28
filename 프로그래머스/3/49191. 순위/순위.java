class Solution {
    public int solution(int n, int[][] results) {
        int[][] list = new int[n+1][n+1];
        int answer = 0;
        
        for(int[] r: results){
            list[r[0]][r[1]] = 1; // 이겼다
            list[r[1]][r[0]] = -1; // 졌다
        }
        
        for(int k = 1 ; k <= n ; k ++){
            for(int i = 1 ; i <= n ; i++){
                for(int j =1 ; j <= n ; j++){
                    if(list[i][k] == 1 && list[k][j] == 1){
                        list[i][j] = 1;
                        list[j][i] = -1;
                    }
                }
            }
        }
        for(int i = 1 ; i <= n ; i ++){
            int cnt = 0 ;
            int[] now = list[i];
            for(int a : now) {
                if(a == 0) cnt++;
            }
            if(cnt == 2) answer ++;
        }
        return answer;
    }
}