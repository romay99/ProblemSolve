import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        
        List<Node> list = new ArrayList<>();
        
        int idx = 0;
        for (int[] s : score) {
            int avg = (s[0] + s[1]);
            list.add(new Node(avg, idx++));
        }
        
        // 평균 내림차순 정렬
        list.sort((a, b) -> b.avg - a.avg);
        
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).avg == list.get(i - 1).avg) {
                // 동점이면 같은 등수
                answer[list.get(i).idx] = answer[list.get(i - 1).idx];
            } else {
                // 아니면 현재 i번째니까 (i+1)등
                answer[list.get(i).idx] = i + 1;
            }
        }
        
        return answer;
    }
}

class Node {
    int avg;
    int idx;
    
    Node(int avg, int idx) {
        this.avg = avg;
        this.idx = idx;
    }
}
