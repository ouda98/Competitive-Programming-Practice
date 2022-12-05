public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {

    }
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    public int helper(int[] nums, int pointer, int res){
        if(pointer >= nums.length){
            return res;
        }
        return helper(nums,pointer+1,res^nums[pointer]) + helper(nums,pointer+1,res);
    }
}
