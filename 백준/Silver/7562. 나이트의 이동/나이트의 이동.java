import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Queue<Node> q = new LinkedList<>();
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Node first = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
            map = new int[size][size];
            q.offer(first);
            st = new StringTokenizer(br.readLine());
            int goalR = Integer.parseInt(st.nextToken());
            int goalC = Integer.parseInt(st.nextToken());

            move:
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node.r == goalR && node.c == goalC) {
                    sb.append(0).append("\n");
                    break move;
                }

                for (int d = 0; d < 8; d++) {
                    int nr = node.r + dr[d];
                    int nc = node.c + dc[d];
                    if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] != -1) {
                        map[nr][nc] = -1;
                        if (nr == goalR && nc == goalC) {
                            sb.append(node.count + 1).append("\n");
                            break move;
                        }
                        q.offer(new Node(nr, nc, node.count + 1));
                    }
                }
            }
        }
        System.out.println(sb);
    }
    static class Node {
        int r;
        int c;
        int count;

        public Node(int r, int c,int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}




