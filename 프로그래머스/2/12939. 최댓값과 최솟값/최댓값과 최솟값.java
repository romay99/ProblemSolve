class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) > max) {
                max = Integer.parseInt(split[i]);
            }
            if (Integer.parseInt(split[i]) < min) {
                min = Integer.parseInt(split[i]);
            }
        }
        return min +" " + max;
    }
}