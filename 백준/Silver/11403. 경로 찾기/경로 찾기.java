import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder resultSb = new StringBuilder();
    static int n;
    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, new boolean[n]);
        }
        for (int[] a : result) {
            for (int j = 0; j < n; j++) {
                resultSb.append(a[j]).append(" ");
            }
            resultSb.append("\n");
        }
        System.out.println(resultSb.toString());
    }

    static void dfs(int rootNode, int nextNode, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (graph[nextNode][i] == 1 && !visited[i]) {
                result[rootNode][i] = 1;
                visited[i] = true;
                dfs(rootNode, i, visited);
            }
        }
    }
}

