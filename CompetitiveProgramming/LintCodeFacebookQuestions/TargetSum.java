package LintCodeFacebookQuestions;

public class TargetSum {
    public static void main(String[] args) {
        int [] nums = {};
        int s = 3;
        System.out.println(findTargetSumWays(nums, s));
    }
    public static int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        return solve(0,nums,s);
    }

    private static int solve(int idx, int[] nums, int s) {
        if(idx == nums.length && s==0)
            return 1;
        if(idx == nums.length)
            return 0;

        return solve(idx+1,nums,s-nums[idx]) +solve(idx+1,nums,s+nums[idx]);
    }
}
