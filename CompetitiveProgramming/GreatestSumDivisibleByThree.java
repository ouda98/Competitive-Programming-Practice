public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {

    }
    static int[][]dp;
    public int maxSumDivThree(int[] nums) {
        dp = new int[3][nums.length];
        return helper(nums, 0, 0);
    }
    public int helper(int[] nums, int sum ,int pointer){
        if(pointer>= nums.length){
            if(sum==0)
                return 0;
            return -1000000;
        }
        if(dp[sum][pointer]!=0)
            return dp[sum][pointer];
        int take = nums[pointer] + helper(nums, (sum+nums[pointer])%3,pointer+1);
        int leave = helper(nums, sum,pointer + 1);
        return dp[sum][pointer] = Math.max(take, leave);
    }
}
