public class OnesAndZeroes {
    public static void main(String[] args) {

    }
    static int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m+1][n+1][strs.length];
        return helper(strs,m,n,0);
    }
    public int helper(String[] strs, int m, int n, int pointer){
        if(n<0 || m <0)
            return -1000000;
        if(pointer>= strs.length){
            if(n>=0 && m>=0)
                return 0;
            else
                return -1000000;
        }
        if(dp[m][n][pointer]!=0)
            return dp[m][n][pointer];
        int zeros = 0;
        int ones = 0;
        for(int i=0;i<strs[pointer].length();i++){
            if(strs[pointer].charAt(i) == '1')
                ones++;
            else
                zeros++;
        }
        int take = 1+ helper(strs, m-zeros,n-ones,pointer+1);
        int leave = helper(strs, m,n,pointer+1);
        return dp[m][n][pointer]= Math.max(take, leave);
    }
}
