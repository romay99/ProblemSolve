import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static String[][] map;
    static List<Node> teacherList = new ArrayList<>();
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    teacherList.add(new Node(i, j));
                }
            }
        }
        back(0);
        System.out.println(result ? "YES" : "NO");
    }

    static void back(int step) {
        if (result) {
            return;
        }
        if (step == 3) {
            int count = 0;
            for (int t = 0; t < teacherList.size(); t++) {
                if (check(teacherList.get(t))) {
                    count++;
                }
            }
            if (count == teacherList.size()) {
                result = true;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    back(step + 1);
                    map[i][j] = "X";
                }
            }
        }
    }
    static boolean check(Node node) {
        for (int i = node.r; i < map.length; i++) {
            if (map[i][node.c].equals("O")) {
                break;
            }
            if (map[i][node.c].equals("S")) {
                return false;
            }
        }
        for (int i = node.r; i >= 0; i--) {
            if (map[i][node.c].equals("O")) {
                break;
            }
            if (map[i][node.c].equals("S")) {
                return false;
            }
        }
        for (int i = node.c; i < map.length; i++) {
            if (map[node.r][i].equals("O")) {
                break;
            }
            if (map[node.r][i].equals("S")) {
                return false;
            }
        }
        for (int i = node.c; i >= 0 ; i--) {
            if (map[node.r][i].equals("O")) {
                break;
            }
            if (map[node.r][i].equals("S")) {
                return false;
            }
        }
        return true;
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

