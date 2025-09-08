import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int round = 0;
        
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int tmp = Math.min(a,b);
        b = Math.max(a,b); // b 가 더 큰번호
        a = tmp; // a 가 더 낮은 번호
        
        while(n >= 1) {
            round++;
            if(b % 2 == 0 && b - a == 1){
                System.out.println(round);
                return;
            }
            if(n % 2 == 0){ // 남은플레이어가 짝수일때
                n /= 2;
                if(a != 1){
                    if(a % 2 == 0){
                        a /= 2;
                    } else {
                        a /=2;
                        a++;
                    }
                }
                if(b % 2 == 0){
                    b /= 2;
                } else {
                    b /= 2;
                    b++;
                }
            } else { //홀수일때
                n /= 2;
                n += 1;
                
                if(a != 1){
                    if(a % 2 == 0){
                        a /= 2;
                    } else {
                        a /=2;
                        a++;
                    }
                }
                if(b % 2 == 0){
                    b /= 2;
                } else {
                    b /= 2;
                    b++;
                }
                
            }
        }
        System.out.println(-1);
        
    }
}