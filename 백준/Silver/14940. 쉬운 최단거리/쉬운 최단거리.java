import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n][m];

        int keyR = 0;
        int keyc = 0;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    keyR = i;
                    keyc = j;
                }
                map[i][j] = num != 0 ? 0 : -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{keyR, keyc});
        visited[keyR][keyc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] != -1) {
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                } else if (map[i][j] == 0) {
                    if (i != keyR || j != keyc) {
                        map[i][j] = -1;
                    }
                }
                sb.append(map[i][j]).append(" ");
                if(j == map[i].length - 1){
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}