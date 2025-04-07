import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = 0 ;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int garo = Integer.parseInt(st.nextToken());
            int sero = Integer.parseInt(st.nextToken());
            int baechu = Integer.parseInt(st.nextToken());

            int[][] map = new int[sero][garo];
            for (int j = 0; j < baechu; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map[0].length; c++) {
                    if (map[r][c] == 1) {
                        dfs(map, r, c);
                        result++;
                    }
                }
            }
            System.out.println(result);
            result = 0 ;
        }
    }

    static void dfs(int[][] map, int r, int c) {
        map[r][c] = 2;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] == 1) {
                dfs(map, nr, nc);
            }
        }
    }
}