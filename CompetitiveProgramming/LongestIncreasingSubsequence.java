import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 1;
        int bs;
        for(int n : nums){
            bs = Arrays.binarySearch(dp,0,res,n);
            if(bs>=0)
                continue;
            bs = bs*-1 -1;
            if(bs == res)
                res++;
            dp[bs] = n;
        }
        return res;
    }
}
