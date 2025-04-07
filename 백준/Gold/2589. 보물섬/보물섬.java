import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map ;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxValue);
    }
    static void bfs(int r , int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0));
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] == 'L') {
                    q.offer(new Node(nr, nc, now.count + 1));
                    maxValue = Math.max(now.count + 1, maxValue);
                    visited[nr][nc] = true;
                }
            }
        }


    }
    static class Node{
        int r ;
        int c;
        int count;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}




