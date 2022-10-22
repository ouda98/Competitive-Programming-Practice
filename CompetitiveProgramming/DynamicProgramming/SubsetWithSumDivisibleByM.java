package DynamicProgramming;

import java.util.Arrays;

public class SubsetWithSumDivisibleByM {
    static int [][]memo;
    public static void main(String[] args) {
        int [] nums = {11, 12, 12, 8, 10, 2, 5};
        int m =9;

        memo = new int[nums.length+1][m+1];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);

        if(solve(nums,0,0,m)==0)
            System.out.println(0);
        else
            System.out.println(1);
    }

    private static int solve(int[] nums, int idx, int sum,int m) {
        if(sum!=0 && sum%m==0)
            return 1;
        if(idx>=nums.length)
            return 0;

        if(memo[idx][sum]!=-1)
            return memo[idx][sum];

        return memo[idx][sum] = solve(nums,idx+1,(sum+nums[idx])%m,m) + solve(nums,idx+1,sum%m,m);

    }

}
