import java.util.HashMap;

public class PerfectSquares {
    public static void main(String[] args) {

    }
    static int[][] map;
    public int numSquares(int n) {
        map = new int[n+1][100];
        int[] squares = new int[100];
        int square = 1;
        int i=0;
        while(true){
            squares[i] = square*square;
            if(square*square >= 10000)
                break;
            i++;
            square++;
        }
        return dfs(squares,n, squares.length-1);
    }
    public int dfs(int[] squares, int n, int pointer){
        if(n<0 || pointer < 0)
            return 1000000;
        if(n==0){
            return 0;
        }
        if(map[n][pointer]!=0){
            return map[n][pointer];
        }
        int take = 1+ dfs(squares, n - squares[pointer],pointer);
        int leave = dfs(squares, n, pointer-1);
        return map[n][pointer] = Math.min(take,leave);
    }
}
