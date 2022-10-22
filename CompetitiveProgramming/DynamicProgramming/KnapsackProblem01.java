package DynamicProgramming;

import java.util.Arrays;

public class KnapsackProblem01 {
    static int[][] memo;

    public static void main(String[] args) {
        int n = 3;
        int W = 4;
        int values[] = {1, 2, 3};
        int weight[] = {4,5,1};
        memo = new int[n + 1][W + 1];
        for(int i=0;i< memo.length;i++)
        Arrays.fill(memo[i], -1);



        System.out.println(kp(values, weight, 0, W));
        for(int i=0;i< memo.length;i++)
            System.out.println(Arrays.toString(memo[i]));
    }

    private static int kp(int[] values, int[] weight, int idx, int w) {
        if (idx == values.length)
            return 0;
        if (w == 0)
            return 0;

        if (memo[idx][w] != -1)
            return memo[idx][w];
        int leave = kp(values,weight,idx+1,w);
        int take =0;
        if(w>= weight[idx])
            take = values[idx]+kp(values,weight,idx+1,w-weight[idx]);
        return memo[idx][w] = Math.max(leave,take);
    }
}
