import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startc = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Node(startR, startc));

        move:
        while (!q.isEmpty()) {
            Node now = q.poll();
//            System.out.println("now = " + now);
            //현재칸 청소
            map[now.r][now.c] = -1;
            boolean allClean = true;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
                    if (map[nr][nc] == 0) {
//                        System.out.println("nr+nc = " + nr+","+nc);
                        allClean = false;
                    }
                }
            }
            if (allClean) {
                // 주변 칸이 전부 청소 되어있을때,
                int nr = now.r + dr[(d + 2) % 4];
                int nc = now.c + dc[(d + 2) % 4];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] != 1) {
                    q.offer(new Node(nr, nc));
                } else if (map[nr][nc] == 1) {
                    break move;
                }
            } else {
                // 주변 칸중 청소되어있지 않은 칸이 있을때,
                d --;
                d += 4;
                d %= 4;
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] == 0) {
                    q.offer(new Node(nr, nc));
                } else {
                    q.offer(new Node(now.r, now.c));
                }
            }
        }
        int result =0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
    static class Node {
        int r;
        int  c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "현재 위치 : r = " + this.r + " c = " + this.c;
        }
    }
}



