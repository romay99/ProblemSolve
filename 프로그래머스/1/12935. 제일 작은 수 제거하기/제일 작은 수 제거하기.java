class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        
        int minValue = Integer.MAX_VALUE;
        int minIdx = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(minValue > arr[i]){
                minValue = arr[i];
                minIdx = i;
            }
        }
        
        int[] answer = new int[arr.length-1];
        int idx = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i == minIdx) continue;
            answer[idx++] = arr[i];
        }
        return answer;
    }
}