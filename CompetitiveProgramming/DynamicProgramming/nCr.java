package DynamicProgramming;

import java.util.Arrays;

public class nCr {
    static int[][] memo;

    public static void main(String[] args) {
        int n = 6;
        int r = 2;
        memo = new int[n + 1][r + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);



        if (r > n)
            System.out.println(0);
        else
            System.out.println(find(n, r));

        for(int i=0;i< memo.length;i++)
            System.out.println(Arrays.toString(memo[i]));

        System.out.println(memo[n][r]);


    }

    private static int find(int n, int r) {
        if (r < 0 || r>n)
            return 0;
        if(r==0 || n==r)
            return 1;

        if (memo[n][r] != -1)
            return memo[n][r];

        return memo[n][r] = (find(n - 1, r - 1) + find(n - 1, r))%((int)(1e9)+7);
    }
}
