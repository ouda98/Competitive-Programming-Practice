package Algorithms;

public class EditDistance {
    public static void main(String[] args) {
        String one = "saturday";
        String two = "sunday";
        System.out.println(distance(one,two));
    }
    public static int distance(String one, String two){
        int oneLength = one.length();
        int twoLength = two.length();
        int[][] dp = new int[oneLength+1][twoLength+1];
        for(int i=0;i<=oneLength;i++){
            for(int j=0;j<=twoLength;j++){
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;

                else if(one.charAt(i-1) == two.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) +1;
                }
            }
        }
        return dp[oneLength][twoLength];
    }
}
