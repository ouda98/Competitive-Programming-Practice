import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param grid: a chessboard included 0 and 1
         * @return: the shortest path
         */
        static int[] dr = {1, -1, 2, -2};
        static int[] dc = {2, 2, 1 , 1};
        public int shortestPath2(boolean[][] grid) {
            // write your code here
            if(grid == null || grid[0][0] == true || grid[grid.length-1][grid[0].length-1] == true)
                return -1;

            Queue<Triple> q = new LinkedList<>();
            q.add(new Triple(0,0,0));
            grid[0][0] = true;
            while(!q.isEmpty()){
                Triple top = q.poll();
                int x, y;
                for(int i=0;i<dr.length;i++){
                    x = top.x + dr[i];
                    y = top.y +dc[i];
                    if(can(grid,x,y)){
                        grid[x][y] = true;
                        q.add(new Triple(x,y,top.distance+1));
                        if(x == grid.length-1 && y == grid[0].length-1)
                            return top.distance +1;
                    }
                }
            }
            return -1;

        }
        public static boolean can(boolean [][]grid, int x, int y){
            return x>=0 && y>=0 && x< grid.length && y < grid[0].length && grid[x][y] == false;
        }

        public static class Triple{
            int x;
            int y;
            int distance;
            public Triple(int x, int y, int distance){
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }
    }
}
