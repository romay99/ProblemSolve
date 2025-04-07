import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp ;
    static List<List<Edge>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        dp = new int[v + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        visited = new boolean[v + 1];

        int start = Integer.parseInt(br.readLine());
        dp[start] = 0;

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(end, weight));
        }

        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int nowVertex = cur.index;

            if (visited[nowVertex]) {
                continue;
            }
            for (int i = 0; i < graph.get(nowVertex).size(); i++) {
                Edge nearEdge = graph.get(nowVertex).get(i);
                if (dp[nearEdge.index] > dp[nowVertex] + nearEdge.weight) {
                    dp[nearEdge.index] = dp[nowVertex] + nearEdge.weight;
                    pq.offer(new Edge(nearEdge.index, dp[nearEdge.index]));
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Edge{
        int index;
        int weight;

        public Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}




