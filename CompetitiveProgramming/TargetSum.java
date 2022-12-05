public class TargetSum {
    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }
    public int dfs(int[] nums, int target, int pointer){
        if(target == 0 && pointer == nums.length)
            return 1;
        if(pointer>=nums.length)
            return 0;
        return dfs(nums, target - nums[pointer], pointer+1) + dfs(nums, target + nums[pointer], pointer+1);
    }
}
