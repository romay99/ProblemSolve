import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet();
        
        for(int a : nums){
            set.add(a);
        }
        int max = nums.length / 2;
        return max < set.size() ? max : set.size();
    }
}