import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> woods = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long maxValue = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        long left = 0;

        st = new StringTokenizer(bf.readLine());

        while (st.hasMoreTokens()){
            woods.add(Integer.parseInt(st.nextToken()));
        }

        while (left < right) {
            long mid = (right + left) / 2;
            if (check(woods, mid, m)) {
                left = mid + 1;
                maxValue = Math.max(maxValue, mid);
            } else {
                right = mid;
            }
        }
        System.out.println(maxValue);
    }

    static boolean check(List<Integer> list, long mid , long m) {
        long sum = 0;
        for (int wood : list) {
            sum += wood > mid ? wood - mid : 0;
            if (sum >= m) {
                return true;
            }
        }
        return false;
    }
}