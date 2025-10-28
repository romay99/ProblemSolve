import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(visited, i, computers);
                answer++;
            }
        }     
        
        return answer;
    }
    void dfs(boolean[] visited, int idx,int[][] arr) {
        int[] cur = arr[idx];
        for(int i = 0 ; i < arr.length ; i++){
            if(i != idx && !visited[i] && cur[i] == 1){
                visited[i] = true;
                dfs(visited,i,arr);
            }
        }
    }
}