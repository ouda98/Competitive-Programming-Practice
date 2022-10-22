package LintCodeBacktracking;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char [][] in = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(in,word));
    }
    static boolean[][] visited;
    static boolean result;
    static int []dr = {0,0,1,-1};
    static int []dc = {1,-1,0,0};
    public static boolean exist(char[][] board, String word) {
        result = false;
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != word.charAt(0))
                    continue;
                visited[i][j] = true;
                solve(board,i,j,word,""+board[i][j]);
                visited[i][j] = false;
                if(result)
                    return true;
            }
        }
        return false;
    }

    public static void solve(char[][] board,int i,int j, String word, String build){
        if(build.length() == word.length()){
            if(build.equals(word))
                result = true;
            return;
        }
        int x,y;
        for(int k=0;k<dr.length;k++){
            x = i +dr[k];
            y = j + dc[k];
            if(valid(visited,x,y)  && word.charAt(build.length()) == board[x][y]){
                visited[x][y] = true;
                solve(board,x,y,word,build + board[x][y]);
                if(result)
                    return;
                visited[x][y] = false;
            }
        }

    }
    public static boolean valid(boolean [][]visited, int x, int y){
        return x>=0 && x< visited.length && y>=0 && y<visited[0].length && !visited[x][y];
    }
}
