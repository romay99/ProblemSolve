import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> first = new LinkedList<>();
        LinkedList<String> second = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            first.add(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            second.add(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            String s = second.get(i);
            if (!first.peekFirst().equals(s)) {
                first.remove(s);
                result++;
            } else {
                first.pollFirst();
            }
        }
        System.out.println(result);
    }
}




