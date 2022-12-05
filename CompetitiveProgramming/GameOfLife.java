public class GameOfLife {
    public static void main(String[] args) {

    }
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                findSituation(i,j,board);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                board[i][j]>>=1;
            }
        }
    }
    public void findSituation(int x, int y, int[][]board){
        int[] r = new int[]{0,0,1,-1,1,-1,-1,1};
        int[] c = new int[]{1,-1,0,0,1,1,-1,-1};
        int live = 0;
        for(int i=0;i<r.length;i++){
            if(isValid(x+r[i],y+c[i],board)){
                live+= board[x+r[i]][y+c[i]]&1;
            }
        }
        if(board[x][y] ==1 && (live ==2 || live ==3))
            board[x][y] = 3;
        else if(board[x][y] ==0 && live == 3)
            board[x][y] = 2;
    }
    public boolean isValid(int i, int j, int[][]board){
        return i>=0 && j>=0 && i<board.length && j<board[i].length;
    }
}
