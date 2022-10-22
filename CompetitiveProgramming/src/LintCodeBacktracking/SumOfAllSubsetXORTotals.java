package LintCodeBacktracking;

public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {

    }
    class Solution {
        public int subsetXORSum(int[] nums) {
            return solve(nums,0, 0);
        }
        public static int solve(int [] nums,int idx, int sum){
            if(idx == nums.length)
                return sum;

            int a = 0;
            a = solve(nums, idx+1, sum^nums[idx]);
            a += solve(nums, idx+1, sum);

            return a;
        }
    }
}
