import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<Character> stack = new Stack();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        main:
        while(true){
            String str = bf.readLine();
            stack = new Stack();
            if(str.equals(".")) break;

            for(int i = 0 ;  i< str.length() ; i++){
                char c = str.charAt(i);
                if(c == '[' || c == '('){
                    stack.push(c);
                } else if (c == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        sb.append("no\n");
                        continue main;
                    } else {
                        stack.pop();
                    }
                } else if (c == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        sb.append("no\n");
                        continue main;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                sb.append("no\n");
            } else {
                sb.append("yes\n");
            }
        }
        System.out.println(sb.toString());
    }
}