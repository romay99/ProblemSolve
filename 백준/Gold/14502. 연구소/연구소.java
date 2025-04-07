import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        makeWall(0);
        System.out.println(maxValue);
    }
    static void makeWall(int count) {
        if (count == 3) {
            bfs();
            return ;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1 ;
                    makeWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
            }
        }
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            int r = now.r;
            int c = now.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2;
                    q.offer(new Node(nr,nc));
                }
            }
        }
        countSafeZone(copyMap);
    }

    static void countSafeZone(int[][] map) {
        int count = 0;
        for (int[] a : map) {
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        maxValue = Math.max(maxValue, count);
    }

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
