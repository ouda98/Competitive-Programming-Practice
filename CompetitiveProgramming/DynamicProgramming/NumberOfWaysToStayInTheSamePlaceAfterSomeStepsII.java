package DynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeStepsII {
    public static void main(String[] args) {
        int steps = 298;
        int arrLen = 382736;
        System.out.println(numWays(steps, arrLen));

    }
    static int [][] dp;
    public static int numWays(int steps, int arrLen) {
        // write your code here
        dp = new int[arrLen][steps+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return solve(0,steps,arrLen);
    }
    static int mod = ((int)1e9+7);
    public static int solve(int position, int steps, int arrLen){
        if(steps == 0 && position == 0){
            return 1;
        }
        if(steps<=0) {
            return 0;
        }
        if(dp[position][steps]!=-1){
            return dp[position][steps];
        }
        int a = 0;
        if(position+1<arrLen && position<= steps)
            a= (a + solve(position+1,steps-1,arrLen)) % mod;
        if(position>0)
            a= (a + solve(position-1,steps-1,arrLen))%mod;
        a= (a + solve(position, steps-1,arrLen))%mod;

        return dp[position][steps] = a;
    }
}
