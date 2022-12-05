import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result;
    static List<Integer> subResult;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0);
        return result;
    }
    public void helper(int[] nums, int pointer){
        if(pointer == nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        subResult.add(nums[pointer]);
        helper(nums, pointer+1);
        subResult.remove(subResult.size()-1);
        while(pointer+1<nums.length && nums[pointer]==nums[pointer+1]){
            pointer++;
        }
        helper(nums, pointer+1);
    }
}
