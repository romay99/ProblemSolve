import java.io.*;
import java.util.*;
public class Main {
    static int[][] map ;
    static boolean[][] visited;
    static int result ;
    static ArrayList<Integer> resultList = new ArrayList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String now = st.nextToken();
            for (int j = 0; j < n; j++) {
                int node = Integer.parseInt(String.valueOf(now.charAt(j)));
                map[i][j] = node;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    result = 0 ;
                    visited[i][j] = true;
                    dfs(i,j);
                    resultList.add(result);
                }
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
    static void dfs(int y , int x ){
        result ++ ;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) continue;
            if(!visited[ny][nx] && map[ny][nx] == 1){
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }
}
