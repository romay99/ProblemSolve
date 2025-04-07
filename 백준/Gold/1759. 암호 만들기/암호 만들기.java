import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Character> motherList = new ArrayList<>();
    static List<String> inputList = new ArrayList<>();
    static int l;
    static int c;
    static StringBuilder resultBuilder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        motherList.add('a');
        motherList.add('e');
        motherList.add('i');
        motherList.add('o');
        motherList.add('u');

        resultBuilder = new StringBuilder();
        for (int i = 0; i < c; i++) {
            inputList.add(st.nextToken());
        }

        inputList.sort((a, b) -> a.compareTo(b));
        back(0,0, new StringBuilder(), new boolean[c]);

        System.out.println(resultBuilder.toString());
    }
    static void back(int start ,int depth,StringBuilder word,boolean[] visited){
        if (depth == l){
            if (haveMotherWord(word)) {
                resultBuilder.append(word.toString()).append("\n");
            }
            return ;
        }

        for (int i = start; i < inputList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                word.append(inputList.get(i));
                back( i+1,depth+1,word,visited);
                word.deleteCharAt(word.length()-1);
                visited[i] = false;
            }
        }
    }

    static boolean haveMotherWord(StringBuilder stringBuilder) {
        int aCount = 0 ;
        int bCount = 0 ;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (motherList.contains(stringBuilder.charAt(i))) {
                aCount++;
            } else {
                bCount++;
            }
        }
        if (aCount > 0 && bCount >= 2) {
            return true;
        } else {
            return false;
        }
    }
}

