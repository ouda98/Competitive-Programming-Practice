import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {
    public static void main(String[] args) {

    }
    static int[] r = new int[]{0,0,1,-1};
    static int[] c = new int[]{1,-1,0,0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i=0;i<grid1.length;i++)
            for(int j=0;j<grid1[i].length;j++){
                if(grid1[i][j] == 1 && grid2[i][j] ==1){
                    count+=bfs(i,j,grid2,grid1);
                    grid1[i][j] = 0;
                    grid2[i][j] = 0;
                }
            }
        return count;
    }

    public int bfs(int x, int y, int[][]grid1, int[][]grid2){
        int same = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        Pair polled;
        while(!q.isEmpty()){
            polled = q.poll();
            for(int i=0;i<r.length;i++){
                int nx = polled.x+r[i];
                int ny = polled.y+c[i];
                if(isValid(nx,ny,grid1)){
                    grid1[nx][ny] = 0;
                    if(grid2[nx][ny] == 1)
                        grid2[nx][ny] = 0;
                    else
                        same = 0;
                    q.add(new Pair(nx,ny));
                }
            }

        }
        return same;
    }

    public boolean isValid(int x, int y, int[][] grid){
        return x>=0 && y>=0 && x<grid.length && y<grid[x].length && grid[x][y] ==1;
    }
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
