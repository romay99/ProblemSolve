import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[][] map;
    static int maxHeight = 0;
    static int result = 1 ;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, num);
                map[i][j] = num;
            }
        }
        for (int i = 0; i < maxHeight; i++) {
            int count = count(i);
            result = Math.max(count, result);
        }
        System.out.println(result);
    }
    static int count(int h) {
        Queue<Node> q = new LinkedList<>();
        int result = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] > h) {
                    q.offer(new Node(i, j));
                    result++;
                }
                while (!q.isEmpty()) {
                    Node now = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = now.r + dr[d];
                        int nc = now.c + dc[d];

                        if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] > h) {
                            q.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}




