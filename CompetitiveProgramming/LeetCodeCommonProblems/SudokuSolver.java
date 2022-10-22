package LeetCodeCommonProblems;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][]board = {{0,0,9,7,4,8,0,0,0},
                {7,0,0,0,0,0,0,0,0},
                {0,2,0,1,0,9,0,0,0},
                {0,0,7,0,0,0,2,4,0},
                {0,6,4,0,1,0,5,9,0},
                {0,9,8,0,0,0,3,0,0},
                {0,0,0,8,0,3,0,2,0},
                {0,0,0,0,0,0,0,0,6},
                {0,0,0,2,7,5,9,0,0}};
        solveSudoku(board);
        for (int i=0;i<board.length;i++)
            System.out.println(Arrays.toString(board[i]));

    }
    public static void solveSudoku(int[][] board) {
        // write your code here
        backtrack(board,0,0);
    }
    public static boolean backtrack(int[][] board, int i, int j){
        if(j >= board.length)
            return backtrack(board,i+1,0);

        if(i==board.length)
            return true;

        if(board[i][j] != 0)
            return backtrack(board,i,j+1);

        for(int k=1;k<=9;k++){
            if(isVaild(board,i,j,k)){
                board[i][j] = k;
                if(backtrack(board,i,j+1))
                    return true;
                board[i][j] = 0;
            }
        }
        return false;
    }

    public static boolean isVaild(int [][] board,int i,int j,int value){
        for(int k=0;k<9;k++){
            if(value == board[i][k])
                return false;
        }
        for(int k=0;k<9;k++){
            if(value == board[k][j])
                return false;
        }
        int r = (i/3)*3;
        int c = (j/3)*3;
        for(int k=r;k<r+3;k++){
            for(int e = c;e<c+3;e++){
                if(board[k][e] == value)
                    return false;
            }
        }
        return true;
    }
}
