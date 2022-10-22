package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static int memo[][];
    static int sum;

    public static void main(String[] args) {
        int N = 4;
        int[] arr = {1, 3, 5,1};
        sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        memo = new int[N+1][sum/2 + 1];
        for(int i=0;i< memo.length;i++)
            Arrays.fill(memo[i],-1);


        if (sum % 2 == 1)
            System.out.println("NO");
        else {
            if(solve(arr, 0, sum/2)==0)
                System.out.println("NO");
            else
                System.out.println("Yes");
        }

    }

    private static int solve(int[] arr, int idx, int left) {

        if (idx == arr.length  && left == 0)
            return 1;
        if (idx > arr.length-1 || left<0)
            return 0;

        if(memo[idx][left]!=-1)
            return memo[idx][left];
        int result=0;
        if(left>=arr[idx])
            result = solve(arr, idx + 1, left - arr[idx]);
        int r =solve(arr, idx + 1, left);
        return memo[idx][left] = result+r;
    }

}
