import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        find(nums,0,new ArrayList<Integer>());
        return result;
    }
    public void find(int [] nums, int i, List<Integer> subResult){
        if(i == nums.length){
            result.add(new ArrayList(subResult));
            return;
        }
        find(nums,i+1,subResult);
        subResult.add(nums[i]);
        find(nums,i+1,subResult);
        subResult.remove(subResult.size()-1);
    }
}
