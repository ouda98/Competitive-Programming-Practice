package LintCodeBacktracking;

import java.util.HashMap;

public class CountNumberOfMaximumBitwiseORSubsets {
    public static void main(String[] args) {
    }
    class Solution {
        static HashMap<Integer, Integer> map;
        public int countMaxOrSubsets(int[] nums) {
            map = new HashMap<>();
            solve(nums, 0, 0);
            int max = Integer.MIN_VALUE;
            int count = 0;
            for(Integer i : map.keySet()){
                if(i>max){
                    max = i;
                    count = map.get(max);
                }
            }
            return count;
        }
        public static void solve(int [] nums, int idx, int sum){
            if(idx == nums.length){
                if(map.containsKey(sum))
                    map.put(sum,map.get(sum)+1);
                else
                    map.put(sum,1);
                return;
            }

            solve(nums, idx+1, sum | nums[idx]);
            solve(nums, idx+1, sum);
        }
    }
}
