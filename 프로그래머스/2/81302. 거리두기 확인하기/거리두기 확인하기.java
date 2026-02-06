import java.util.*;
class Solution {
    static boolean flag = false;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[][] map = new int[5][5];
        boolean[][] visited = new boolean[5][5];
        
        skip:
        for(int z = 0 ; z < places.length ; z++){
            initMap(places[z] ,map); // 맵 초기화
            flag = false;
            visited = new boolean[5][5];
            
            for(int i = 0 ; i < 5 ; i ++){
                for(int j = 0 ; j < 5 ; j++){
                    if(map[i][j] == 1){
                        bfs(map, i , j, visited);
                        if(flag == true){
                            answer[z] = 0;
                            continue skip;
                        }
                    }
                }
            }
            answer[z] = 1;
        }
        return answer;
    }
    
    void initMap(String[] places,int[][] map){
    for(int i = 0 ; i < 5 ; i ++){
        for(int j = 0 ; j < 5 ; j ++){
            char c = places[i].charAt(j);

            if(c =='P'){
                map[i][j] = 1;
            } else if(c=='X'){
                map[i][j] = -1;
                } else {
                map[i][j] = 0;
            }
            }
        }
    }
    

    
    void bfs(int[][] map, int a , int b , boolean[][] visited){
        Queue<Node> q = new LinkedList();
        q.offer(new Node(a,b));
        visited[a][b] = true;
        
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        main:
        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && map[nr][nc] != -1 && !visited[nr][nc] ){
                    if(map[nr][nc] == 1){
                        if(man(nr , nc , a ,b)){ // 거리유지 실패
                            flag = true;
                            break main;
                        }
                    } else {
                        if(man(a,b , nr , nc)){
                            visited[nr][nc] = true;
                            q.offer(new Node(nr,nc));
                        }
                    }
                }
            }
        }
    }
    

    
    boolean man(int r1,int c1 , int r2, int c2){ 
        float result = Math.abs(r1 - r2) + Math.abs(c1-c2);
        
        return result > 2 ? false : true;
    }
}

class Node{
    int r;
    int c;

    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}