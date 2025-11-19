class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length + 1][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        int result = Integer.MIN_VALUE;
        if(land.length == 1){
            for(int i = 0 ; i < 4 ; i ++){
                result = Math.max(dp[0][i],result);
            }
            return result;
        }
        
        for(int i = 1 ; i < land.length ; i ++){
            for(int j = 0 ; j < 4 ; j ++){
                int max = Integer.MIN_VALUE;
                if(j == 0){
                    max = Math.max(dp[i-1][1],dp[i-1][2]);
                    max = Math.max(max , dp[i-1][3]);
                    dp[i][j] = max + land[i][j];
                } else if (j == 1){
                    max = Math.max(dp[i-1][0],dp[i-1][2]);
                    max = Math.max(max , dp[i-1][3]);
                    dp[i][j] = max + land[i][j];
                } else if(j == 2){
                    max = Math.max(dp[i-1][1],dp[i-1][0]);
                    max = Math.max(max , dp[i-1][3]);
                    dp[i][j] = max + land[i][j];
                } else if(j == 3){
                    max = Math.max(dp[i-1][1],dp[i-1][2]);
                    max = Math.max(max , dp[i-1][0]);
                    dp[i][j] = max + land[i][j];
                }
            }
        }
        for(int a : dp[land.length - 1]){
            result = Math.max(a,result);
        }

        return result;
    }
}