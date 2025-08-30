import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        HashMap<String,Integer> nameNum = new HashMap<>();
        HashMap<Integer,String> numName =new HashMap<>();
        
        
        for(int i = 0 ; i < n ; i ++){
            int num = i + 1;
            String name = bf.readLine();
            
            nameNum.put(name,num);
            numName.put(num,name);
        }
        
        for(int i = 0 ; i < m ; i ++){
            String str = bf.readLine();
            
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
                // 숫자라면
                String answer = numName.get(Integer.parseInt(str));
                sb.append(answer).append("\n");
            } else {
                // 이름이라면
                int answer = nameNum.get(str);
                sb.append(String.valueOf(answer)).append("\n");
            }
        }
        System.out.println(sb);
        
    }
}