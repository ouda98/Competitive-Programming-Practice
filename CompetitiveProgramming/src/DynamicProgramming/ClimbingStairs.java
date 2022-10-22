package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public class Solution {
        /**
         * @param n: An integer
         * @return: An integer
         */
        static int [] dp;
        public int climbStairs(int n) {
            // write your code here
            if(n==0)
                return 0;
            dp = new int [n+1];
            Arrays.fill(dp,-1);
            return climb(n);
        }
        public static int climb(int n){
            if(n==0)
                return 1;
            if(dp[n]!=-1)
                return dp[n];
            int a =0;
            if(n>1)
                a = climb(n-2);
            if(n>0)
                a+= climb(n-1);

            return dp[n] = a;
        }
    }
}
