import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        int result = 0 ;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        q.add(new Node(0, 0, 1));
        move:
        while (!q.isEmpty()) {
            Node now = q.poll();
            int r = now.r;
            int c = now.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] != 0) {
                    if (map[nr][nc] == 1) {
                        if (nr == map.length - 1 && nc == map[0].length - 1) {
                            result = now.count + 1;
                            break move;
                        }
                        q.offer(new Node(nr, nc, now.count + 1));
                        map[nr][nc] = -1;
                    }
                }
            }
        }
        System.out.println(result);
    }
    static class Node {
        int r;
        int c;
        int count ;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}




