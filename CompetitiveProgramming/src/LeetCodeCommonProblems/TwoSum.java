package LeetCodeCommonProblems;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int value;
        for(int i=0;i<nums.length;i++){
            value = target - nums[i];
            if(map.containsKey(value)){
                int [] result = new int[2];
                result[1] = i;
                result[0] = map.get(value);
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
