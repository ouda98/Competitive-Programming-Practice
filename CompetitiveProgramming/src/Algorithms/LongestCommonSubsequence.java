package Algorithms;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] +1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }

}
