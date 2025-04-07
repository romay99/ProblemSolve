import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static List<Integer> resultList = new ArrayList<>();
    static StringBuilder resultSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            drawSquare(c1, r1, c2, r2);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i,j,visited);
                }
            }
        }
        resultList.sort((a, b) -> a - b);
        for (int a : resultList) {
            resultSb.append(a).append(" ");
        }
        resultSb.deleteCharAt(resultSb.length() - 1);
        System.out.println(resultList.size());
        System.out.println(resultSb.toString());

    }

    static void drawSquare(int r1, int c1, int r2, int c2) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                map[i][j] = 1;
            }
        }
    }

    static void bfs(int r, int c , boolean[][] visited) {
        int result = 0;
        visited[r][c] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        while (!q.isEmpty()) {
            result++;
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] == 0) {
                    q.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        resultList.add(result);
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

