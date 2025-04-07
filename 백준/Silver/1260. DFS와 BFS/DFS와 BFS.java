import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v, new boolean[n + 1]);
        sb.append("\n");
        bfs(v, new boolean[n + 1]);
        System.out.println(sb);
    }

    static void dfs(int index, boolean[] visited) {
        visited[index] = true;
        sb.append(index).append(" ");
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && graph[index][i] == 1) {
                visited[i] = true;
                dfs(i, visited);
            }
        }
    }

    static void bfs(int index, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visited[index] = true;
        sb.append(index).append(" ");
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 1 ; i < graph[now].length; i++) {
                if (!visited[i] && graph[now][i] == 1) {
                    q.offer(i);
                    sb.append(i).append(" ");
                    visited[i] = true;
                }
            }
        }
    }
}




