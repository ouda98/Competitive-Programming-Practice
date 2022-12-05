import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPathSum {
    public static void main(String[] args) {

    }
    static int [] r = new int[]{0,1};
    static int [] c = new int[]{1,0};
    public int minPathSum(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        distance[0][0] = grid[0][0];
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for(int i=0;i<r.length;i++){
                int nx = top.x+r[i];
                int ny = top.y+c[i];
                if(isValid(nx,ny,grid)){
                    if(top.d + grid[nx][ny]<distance[nx][ny]){
                        distance[nx][ny] = top.d + grid[nx][ny];
                        pq.add(new Pair(nx,ny,distance[nx][ny]));
                    }
                }
            }
        }
        return distance[distance.length-1][distance[0].length-1];
    }
    public boolean isValid(int x, int y, int[][] grid){
        return x>=0 && y>=0 && x<grid.length && y<grid[x].length;
    }
    public class Pair implements Comparable{
        int x;
        int y;
        int d;
        public Pair(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public int compareTo(Object o){
            return Integer.compare(this.d, ((Pair)o).d);
        }
    }
}
