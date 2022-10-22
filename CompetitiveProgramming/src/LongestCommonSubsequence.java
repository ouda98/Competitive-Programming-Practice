public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCD","EDCA"));
    }
    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
        int[][] dp = new int[A.length()+1][B.length()+1];
        if(A.length()==0 || B.length()==0)
            return 0;


        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(j==0 || i==0)
                    dp[i][j] = 0;
                else if(A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
