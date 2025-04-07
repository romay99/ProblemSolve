import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int days = 0;
        boolean[][] visitied = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    q.offer(new int[]{i, j, 0});
                    visitied[i][j] = true;
                }
                map[i][j] = a;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visitied[nr][nc] && map[nr][nc] != -1) {
                    visitied[nr][nc] = true;
                    map[nr][nc] = 1;
                    days = Math.max(days, now[2] + 1);
                    q.offer(new int[]{nr, nc, now[2] + 1});
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return ;
                }
            }
        }
        System.out.println(days);
    }
}