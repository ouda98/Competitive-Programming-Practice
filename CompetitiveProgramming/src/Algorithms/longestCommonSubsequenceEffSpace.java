package Algorithms;

public class longestCommonSubsequenceEffSpace {
    public static void main(String[] args) {
        String one = "saturday";
        String two = "sunday";
        int result = lcs(one,two);
        System.out.println(result);
    }
    public static int lcs(String one, String two){
        int dp[][] = new int[2][two.length()+1];

        for(int i=1;i<=one.length();i++){
            for(int j=0;j<=two.length();j++){
                if(j == 0)
                    dp[i%2][j] = 0;
                else if(one.charAt(i-1) == two.charAt(j-1))
                    dp[i%2][j] = 1+ dp[(i-1)%2][j-1];

                else{
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
                }

            }
        }
        return dp[one.length()%2][two.length()];
    }
}
