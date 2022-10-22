package DynamicProgramming;

import java.util.HashMap;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int [] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int r = minCostClimbingStairs(cost);
        System.out.println(r);
    }
    static HashMap<String,Integer> dp;
    public static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        dp = new HashMap<>();
        int zero = solve(cost,0,0);
        int one = solve(cost,1,0);
        return Math.min(zero, one);
    }

    private static int solve(int[] cost, int idx, int c) {
        if(idx == cost.length)
            return c;
        if(idx == cost.length)
            return 0;
        if(dp.containsKey(idx+" "+c))
            return dp.get(idx+" "+c);

        int a = -1;
        int b = -1;
        if(idx+2<=cost.length)
            a = solve(cost, idx+2,c + cost[idx]) % ((int) 1e9 +7);
        if(idx+1<= cost.length)
            b = solve(cost, idx+1,c + cost[idx])% ((int) 1e9 +7);
        int min;
        if(a!=-1 && b!=-1)
            min = Math.min(a,b);
        else if(a!=-1)
            min =a;
        else
            min = b;
        dp.put(idx+" "+c, min);
        return min;
    }

}
