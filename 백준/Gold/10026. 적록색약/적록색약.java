import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] map;
    static char[][] disableMap;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        disableMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                c = c == 'G' ? 'R' : c;
                disableMap[i][j] = c;
            }
        }
        int count1 = count(map);
        int count2 = count(disableMap);
        System.out.println(count1 + " " + count2);
    }

    static int count(char[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j]) {
                    count++;
                    q.offer(new Node(i, j));
                }
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    char c = map[node.r][node.c];

                    for (int d = 0; d < 4; d++) {
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];

                        if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !visited[nr][nc] && map[nr][nc] == c) {
                            q.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        return count;
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




