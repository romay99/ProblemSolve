import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Car> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String cur = records[i];
            String[] arr = cur.split(" ");

            if (arr[2].equals("IN")) {
                map.put(arr[1], getMin(arr[0]));
            } else { // OUT
                int result = getMin(arr[0]) - map.get(arr[1]);
                if(resultMap.containsKey(arr[1])) {
                    resultMap.put(arr[1],resultMap.get(arr[1]) + result);
                } else {
                    resultMap.put(arr[1], result);
                }
                map.remove(arr[1]);
            }
        }

        if (!map.isEmpty()) {
            for (String cur : map.keySet()) {
                int result = 1439 - map.get(cur);
                if(resultMap.containsKey(cur)){
                    resultMap.put(cur,resultMap.get(cur) + result);
                } else {
                    resultMap.put(cur,result);
                }
                // map.remove(cur);
            }
        }

        for(String cur : resultMap.keySet()) {
            list.add(new Car(cur,resultMap.get(cur)));
        }

        list.sort((a, b) -> a.num.compareTo(b.num));

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            int cur = list.get(i).min;
            if (cur <= fees[0]) {
                answer[i] = fees[1];
            } else {
                cur -= fees[0];
                answer[i] = fees[1];

                if (cur / fees[2] > 0) {
                    answer[i] += (cur / fees[2]) * fees[3];
                }
                if (cur % fees[2] > 0) {
                    answer[i] += fees[3];
                }
            }
        }

        return answer;
    }

    int getMin(String min) {
        String[] tmp = min.split(":");
        int h = Integer.parseInt(tmp[0]) * 60;
        int m = Integer.parseInt(tmp[1]);

        return h + m;
    }
}   
class Car{
    String num;
    int min;

    Car(String num,int min){
        this.num = num;
        this.min = min;
    }
}