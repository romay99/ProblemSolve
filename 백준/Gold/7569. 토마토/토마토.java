import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static int maxValue = 0 ;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        Queue<Node> q = new LinkedList<>();


        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        q.offer(new Node(i, j, k, 0));
                    }
                    map[k][i][j] = num;
                }
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                int nh = now.h + dh[i];

                if (nr >= 0 && nr < map[0].length && nc >= 0 && nc < map[0][0].length && nh >= 0 && nh < map.length) {
                    if (map[nh][nr][nc] == 0) {
                        map[nh][nr][nc] = 1;
                        q.offer(new Node(nr, nc, nh, now.count + 1));
                        maxValue = Math.max(maxValue, now.count + 1);
                    }
                }
            }
        }
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return ;
                    }
                }
            }
        }
        System.out.println(maxValue);
    }
    static class Node {
        int r;
        int c;
        int h;
        int count;

        public Node(int r, int c,int h ,int count) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.count = count;
        }
    }
}




