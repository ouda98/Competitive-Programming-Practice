public class SurroundedRegions {
    public static void main(String[] args) {

    }
    static int[] left = new int[] {0,1,0,-1};
    static int[] right = new int[]{1,0,-1,0};
    public void surroundedRegions(char[][] board) {
        // write your code here
        if(board.length <= 2)
            return;
        for(int i=0;i<board[0].length;i++)
            if(board[0][i]== 'O'){
                board[0][i] = '*';
                dfs(0,i,board);
            }
        for(int i=0;i<board[0].length;i++)
            if(board[board.length-1][i]== 'O'){
                board[board.length-1][i] = '*';
                dfs(board.length-1,i,board);
            }
        for(int i=0;i<board.length;i++)
            if(board[i][0]== 'O'){
                board[i][0] = '*';
                dfs(i,0,board);
            }
        for(int i=0;i<board.length;i++)
            if(board[i][board[i].length-1]== 'O'){
                board[i][board[i].length-1] = '*';
                dfs(i,board[i].length-1,board);
            }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
    }
    public void dfs(int i, int j, char[][] board){
        for(int k=0;k<left.length;k++){
            if(valid(i,j, k,board)){
                board[i+left[k]][j+right[k]] = '*';
                dfs(i+left[k],j+right[k],board);
            }
        }
    }
    public boolean valid(int i, int j, int k, char[][]board){
        return i+left[k]>=0 && i+left[k]<board.length && j+right[k]>=0 && j+right[k] < board[i+left[k]].length && board[i+left[k]][j+right[k]] == 'O';
    }
}
