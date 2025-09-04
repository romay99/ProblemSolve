import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int min = 257;
        int max = -1;
        int maxHeight = 256;
        int minTime = Integer.MAX_VALUE;
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[n * m];
        int idx = 0;
        
        for(int i = 0;  i < n ; i ++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0 ; j < m ; j++){
                int now = Integer.parseInt(st.nextToken());
                min = Math.min(min,now);
                max = Math.max(max,now);
                arr[idx++] = now;
            }
        }
        
        for(int i = max ; i >= min ; i --){ // i = 만드려는 높이 수치
            int haveBlock = b; // 인벤에 갖고있는 블럭수로 초기화
            int result = 0;
            
            for(int now : arr){
                if(now < i){ // 더 낮을때. 블럭 놓기
                    result += i - now;
                    haveBlock -= i - now;
                } else if (now > i) {// 더 높을때. 블럭 부수기
                    result += ( now - i ) * 2;
                    haveBlock += now - i;
                }
            }
            if(haveBlock >= 0 ){
                if(result < minTime){
                    minTime = result;
                    maxHeight = i;
                }
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }
}