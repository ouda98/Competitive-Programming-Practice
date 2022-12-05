import java.util.LinkedList;
import java.util.Queue;

public class SurfaceAreaOf3DShapes {
    public static void main(String[] args) {

    }
    static int[] r = new int[]{0,0,1,-1};
    static int[] c = new int[]{1,-1,0,0};
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        visited[0][0] = true;
        Pair top;
        while(!q.isEmpty()){
            top = q.poll();
            if(grid[top.x][top.y]!=0)
                sum+= grid[top.x][top.y]*4+2;
            for(int i=0;i<r.length;i++)
                if(isValid(top.x+r[i],top.y+c[i],grid)){
                    if(grid[top.x][top.y]!=0)
                        sum-= Math.min(grid[top.x+r[i]][top.y+c[i]], grid[top.x][top.y]);
                    if(!visited[top.x+r[i]][top.y+c[i]]){
                        q.add(new Pair(top.x+r[i],top.y+c[i]));
                        visited[top.x+r[i]][top.y+c[i]] = true;
                    }
                }
        }
        return sum;
    }
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public boolean isValid(int x, int y, int[][] grid){
        return x>=0 && x<grid.length && y>=0 && y<grid[x].length;
    }
}
