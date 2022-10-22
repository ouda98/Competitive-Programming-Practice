package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumProblem {
    static long[][] memo;
    public static void main(String[] args) {
        int N = 100;
        int []arr = {3, 82, 82, 56, 96, 90, 16, 90, 32, 1, 27, 60, 65, 22, 19, 36, 17, 16, 71, 31, 55, 59, 28, 34, 78, 44, 42, 33, 52, 66, 99, 6, 100, 80, 61, 47, 70, 76, 36, 53, 28, 14, 12, 44, 88, 82, 31, 4, 97, 2, 34, 4, 12, 13, 37, 89, 56, 78, 22, 59, 96, 72, 64, 95, 52, 76, 41, 73, 3, 28, 25, 30, 42, 89, 25, 29, 22, 8, 32, 19, 61, 17, 74, 72, 30, 10, 60, 37, 40, 33, 96, 87, 5, 11, 33, 8, 87, 25, 32, 89};
        int sum = 1155;

        memo = new long[N][sum+1];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
        long a =solve(arr,0,sum);
        for(int i=0;i<memo.length;i++)
            System.out.println(Arrays.toString(memo[i]));
        System.out.println(a);

    }

    private static long solve(int[] arr, int idx, int sum) {
        if(sum==0){
            System.out.println("here");
            return 1;
        }

        if(idx>= memo.length)
            return 0;

        if(memo[idx][sum]!=-1)
            return memo[idx][sum];

        long result = 0;
        if(sum>=arr[idx])
            result = solve(arr,idx+1,sum-arr[idx]);
        result+= solve(arr,idx+1,sum);

        return memo[idx][sum]= result;
    }
}
