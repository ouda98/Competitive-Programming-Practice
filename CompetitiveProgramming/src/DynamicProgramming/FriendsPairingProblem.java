package DynamicProgramming;

import java.util.Arrays;

public class FriendsPairingProblem {
    static long[] memo;
    public static void main(String[] args) {
        int n  =4;
        memo = new long[n+1];
        Arrays.fill(memo,-1);
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if(n<=2)
            return n;

        if(memo[n]!=-1)
            return memo[n];

        return memo[n] = (solve(n-1)+(n-1)*solve(n-2))%((int)1e9+7);


    }
}
