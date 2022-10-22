public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int [][] matrix = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        System.out.println(countSquares(matrix));
    }
    static public int countSquares(int[][] matrix) {

        int row = matrix.length, col = matrix[0].length, answer = 0;
        int[][] dp = new int[row][col];

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                answer += dp[i][j];
            }
        }
        return answer;
    }
}
