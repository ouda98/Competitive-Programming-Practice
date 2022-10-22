import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {

    }
    public class Triple{
        int x,y,distance;
        public Triple(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static int[] dr = new int[]{1,0,-1,0,1,-1,1,-1};
    static int[] dc = new int[]{0,1,0,-1,1,-1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0][0] ==1 || grid[grid.length-1][grid.length-1] ==1)
            return -1;
        if(grid.length ==1)
            return 1;
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(0,0,1));
        Triple r;
        while(!q.isEmpty()){
            r = q.poll();
            for(int i=0;i<dr.length;i++){
                if(isValid(r.x,r.y,dr[i],dc[i],grid)){
                    if(grid[r.x+dr[i]][r.y+dc[i]] == 0 && r.x+dr[i]==grid.length-1 && r.y+dc[i]== grid.length-1)
                        return r.distance+1;
                    grid[r.x+dr[i]][r.y+dc[i]] = 1;
                    q.add(new Triple(r.x+dr[i],r.y+dc[i],r.distance+1));
                }
            }
        }
        return -1;

    }

    public boolean isValid(int x, int y, int i, int j, int[][] grid){
        return x+i>=0 && x+i < grid.length && y+j>=0 && y+j<grid.length && grid[x+i][y+j] == 0;
    }
}
