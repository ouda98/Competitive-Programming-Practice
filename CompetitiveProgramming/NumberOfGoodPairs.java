import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {

    }
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int value;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==1)
                continue;
            else{
                value = map.get(nums[i]);
                sum -= (value-1)*(value-2)/2;;
                sum+= value*(value-1)/2;;
            }
        }
        return sum;
    }
}
