import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int[] dr = {1, -1, 0, 0};
  static int[] dc = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
      }
    }
    boolean[][] visited = new boolean[map.length][map[0].length];
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || i == map.length - 1 || j == 0 || j == map[0].length - 1) {
          pq.offer(new Node(i, j, map[i][j]));
          visited[i][j] = true;
        }
      }
    }
    int water = 0;
    while (!pq.isEmpty()) {
      Node now = pq.poll();
      for (int i = 0; i < 4; i++) {
        int nr = now.r + dr[i];
        int nc = now.c + dc[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
          visited[nr][nc] = true;

          water += Math.max(0, now.height - map[nr][nc]);
          pq.offer(new Node(nr, nc, Math.max(now.height, map[nr][nc])));

        }
      }
    }
    System.out.println(water);
  }

  static class Node {

    int r;
    int c;
    int height;

    public Node(int r, int c, int height) {
      this.r = r;
      this.c = c;
      this.height = height;
    }
  }
}
