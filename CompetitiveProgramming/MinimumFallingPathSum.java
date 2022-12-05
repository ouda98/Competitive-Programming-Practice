public class MinimumFallingPathSum {
    public static void main(String[] args) {

    }
    static int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix.length];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i+=2)
            min = Math.min(min, helper(matrix,0,i));
        return min;
    }
    public int helper(int[][] matrix, int x, int y){
        if(x >= matrix.length)
            return 0;
        if(dp[x][y]!=0)
            return dp[x][y];
        int bl = 1000000;
        int br = 1000000;
        int b =  matrix[x][y] + helper(matrix, x+1, y);
        if(y-1 >=0)
            bl = matrix[x][y-1] + helper(matrix, x+1, y-1);
        if(y+1 <matrix.length)
            br = matrix[x][y+1] + helper(matrix, x+1, y+1);
        return dp[x][y] = Math.min(b, Math.min(br,bl));
    }
}
