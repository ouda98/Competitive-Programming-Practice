package LeetCodeCommonProblems;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] c = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(c));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            set.clear();
            for(int j=0;j<board.length;j++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        for(int i=0;i<board.length;i++){
            set.clear();
            for(int j=0;j<board.length;j++){
                if(board[j][i] == '.')
                    continue;
                if(set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
            }
        }
        int row =0;
        int column = 0;
        for(int i=0;i<9;i++){
            if(i%3==0){
                row = i;
                column = 0;
            }
            else{
                column+=3;
            }
            int r = row;
            int c = column;
            set.clear();
            for(r=row;r<row+3;r++){
                for(c=column;c<column+3;c++){
                    if(board[r][c] == '.')
                        continue;
                    if(set.contains(board[r][c]))
                        return false;
                    set.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
