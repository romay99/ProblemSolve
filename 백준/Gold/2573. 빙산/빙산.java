import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0 ;
        boolean isZero = false;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean[][] visited = new boolean[n][m];
            result++;
            melt();
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        count++;
                        countSize(i, j, visited);
                    }
                }
            }
            if (count == 0) {
                isZero = true;
                break;
            }
            if (count > 1) {
                break;
            }
        }
        if (isZero) {
            System.out.println(0);
        } else{
            System.out.println(result);
        }
    }

    static void melt() {
        HashMap<Node,Integer> willMeltCount = new HashMap<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    int count = 0 ;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] < 1) {
                            count++;
                        }
                    }
                    willMeltCount.put(new Node(i, j), count);
                }
            }
        }
        willMeltCount.entrySet().stream().forEach((a) -> map[a.getKey().r][a.getKey().c] -= a.getValue());
    }

    static void countSize(int r, int c , boolean[][] visited) {
        visited[r][c] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] > 0) {
                    q.offer(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
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

