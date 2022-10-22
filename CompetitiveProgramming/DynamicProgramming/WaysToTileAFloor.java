package DynamicProgramming;

import java.util.Arrays;

public class WaysToTileAFloor {
    static long[] memo;
    public static void main(String[] args) {
        int n = 3;
        memo = new long[n+1];
        Arrays.fill(memo,-1);
        System.out.println(til(n));

    }

    private static long til(int n) {
        if(n==1 || n==2)
            return memo[n] = n;
        if(memo[n]!=-1)
            return memo[n];

        return memo[n] = til(n-1)+til(n-2);

    }
}
