import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        List<Integer> list = new ArrayList<>();
        int[] countArr = new int[8001];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            countArr[num + 4000] ++;
        }
        int maxCount = 0 ;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (maxCount < countArr[num + 4000]) {
                maxCount = countArr[num + 4000];
                list.clear();
                list.add(num);
            } else if (maxCount == countArr[num + 4000]) {
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        list.sort((a, b) -> a - b);

        System.out.println(Math.round(sum / n));
        System.out.println(arr[n / 2]);
        System.out.println(list.size() >= 2 ? list.get(1): list.get(0));
        System.out.println(Math.abs(arr[0] - arr[arr.length-1]));
    }
}


