import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.add(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort((a,b) -> {
            if (a[0].equals(b[0])) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (Integer[] arr : list) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}