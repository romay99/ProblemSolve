import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        final int MAX_LIMIT = 100000;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX_LIMIT + 1];
        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.now + 1 == k || cur.now * 2 == k || cur.now - 1 == k) {
                System.out.println(cur.count + 1);
                return;
            }
            if (cur.now + 1 < visited.length && !visited[cur.now + 1]) {
                visited[cur.now + 1] = true;
                q.offer(new Node(cur.now + 1, cur.count + 1));
            }
            if (cur.now - 1 >= 0 && !visited[cur.now - 1]) {
                visited[cur.now-1] = true;
                q.offer(new Node(cur.now - 1, cur.count + 1));
            }
            if(cur.now * 2 < visited.length && !visited[cur.now * 2]) {
                visited[cur.now * 2] = true;
                q.offer(new Node(cur.now * 2, cur.count + 1));
            }
        }
    }

    static class Node {
        int now;
        int count;

        public Node(int now,int count) {
            this.now = now;
            this.count = count;
        }
    }
}