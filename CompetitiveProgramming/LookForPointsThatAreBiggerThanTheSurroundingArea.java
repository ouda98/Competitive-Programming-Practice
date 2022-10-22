public class LookForPointsThatAreBiggerThanTheSurroundingArea {
    public class Solution {
        /**
         * @param grid: a matrix
         * @return: Find all points that are strictly larger than their neighbors
         */
        static int [] dr = {0,0,1,1,-1,-1,-1,1};
        static int [] dc = {1,-1,0,1,0,-1,1,-1};
        public int[][] highpoints(int[][] grid) {
            // write your code here
            int [][] result = new int [grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(solve(grid,i,j)){
                        result[i][j] = 1;
                        j++;
                    }

                }
            }
            return result;
        }
        public static boolean solve(int[][] grid, int i, int j){
            int x, y;
            for(int k=0;k<dr.length;k++){
                x = i + dr[k];
                y = j + dc[k];
                if(valid(grid,x,y) && grid[x][y]>=grid[i][j])
                    return false;
            }
            return true;
        }
        public static boolean valid(int[][] grid, int x, int y){
            return x>=0 && x<grid.length && y>=0 && y< grid[0].length;
        }
    }
}
