package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    static int [][] memo;
    public static void main(String[] args) {
        int n = 10;
        int m = 4;
        int[] S = {2,5,3,6};
        memo = new int[m+1][n+1];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);

        System.out.println(change(S,0,n));

        for(int i=0;i<memo.length;i++)
            System.out.println(Arrays.toString(memo[i]));

    }

    private static int change(int[] s, int idx, int left) {
        if(left==0)
            return 1;

        if(idx>=s.length)
            return 0;

        if(memo[idx][left]!=-1)
            return memo[idx][left];

        int result = 0;

        if(left>= s[idx])
            result = change(s,idx,left-s[idx]);

        result+= change(s,idx+1,left);

        return memo[idx][left] = result;

    }
}
