import java.util.*;
import java.io.*;

public class Main{
    static HashMap<String,Integer> map;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        list = new ArrayList<>();

        int[] arr = new int[n];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < n ; i ++){
            back(0,i,m,arr,new StringBuilder());
        }

        StringBuilder result = new StringBuilder();
        for(String s : list){
            result.append(s);
            result.deleteCharAt(result.length()-1);
            result.append("\n");
        }
        System.out.print(result.toString());
    }
    static void back(int depth , int start , int end, int[] arr,StringBuilder sb){
        if(depth == end){
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(),1);
                list.add(sb.toString());
            }
            return ;
        }
        for(int i = start ; i < arr.length ; i++){
            int length = sb.length();
            sb.append(arr[i]).append(" ");
            back(depth + 1, i , end , arr , sb);
            sb.setLength(length);
        }
    }
}