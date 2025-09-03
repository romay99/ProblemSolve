import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        ArrayList<Long> list = new ArrayList<>();
        int max = 10000;
        long num = 666;
        
        while(list.size() <= max){
            if(String.valueOf(num).indexOf("666") > -1){
                list.add(num);
            }
            num++;
        }
        System.out.println(list.get(n-1));
    }
}