import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        back(0,new StringBuilder());

        if (k > list.size() + 1) {
            System.out.println(-1);
            return ;
        }
        k--;
        Collections.sort(list, (a, b) -> a.compareTo(b));

        for (int i = 0; i < list.get(k).length(); i++) {
            sb.append(list.get(k).charAt(i)).append("+");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static void back(int sum, StringBuilder sb) {
        for (int i = 1; i <= 3; i++) {
            if (sum + i == n) {
                list.add(sb.append(i).toString());
                sb.setLength(sb.length() - 1);
                continue;
            }

            if (sum + i < n) {
                back(sum + i , sb.append(i));
                sb.setLength(sb.length() - 1);
            }
        }
    }
}

