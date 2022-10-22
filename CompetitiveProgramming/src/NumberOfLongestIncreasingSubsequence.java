import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] arr = {1,3,5,4,7};

        System.out.println(findNumberOfLIS(arr));

    }
    public static  int findNumberOfLIS(int[] nums) {
        // Write your code here
        if(nums == null)
            return 0;
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int[] dp = new int[nums.length];
        int [] count = new int[nums.length];
        int top = 1;
        dp[0] = 1;
        count[0] =1;
        for(int i=1;i<nums.length;i++){
            dp[i] =1;
            count[i] =1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j] + 1 >dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
            top = Math.max(top, dp[i]);
        }
        int res = 0;
        for(int i=0;i<count.length;i++)
            if(dp[i] == top)
                res+= count[i];
        return res;
    }
}
