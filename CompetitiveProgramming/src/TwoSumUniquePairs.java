import java.util.HashMap;

public class TwoSumUniquePairs {
    public int twoSum6(int[] nums, int target) {
        // write your code here
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int value;
        for (int i = 0; i < nums.length; i++) {
            value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != -1) {
                counter++;
                map.put(value, -1);
                map.put(nums[i], -1);
                continue;
            }
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
        }
        return counter;
    }
}
