import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        List<Integer> arr = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
        }

        List<Stack<Integer>> stackList = new ArrayList<>();
        boolean isPossible = true;

        for (int i = 0; i < 4; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            stackList.add(stack);
        }

        for (int i = 0; i < arr.size(); i++) {
            int nowNumber = arr.get(i);
            boolean canAdd = false;

            for (int j = 0; j < 4; j++) {
                Stack<Integer> nowStack = stackList.get(j);
                if (nowStack.peek() < nowNumber) {
                    nowStack.add(nowNumber);
                    canAdd = true;
                    break;
                }
            }
            if (!canAdd) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}