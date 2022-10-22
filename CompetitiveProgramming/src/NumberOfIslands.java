public class NumberOfIslands {
    public class Solution {
        /**
         * @param grid: a boolean 2D matrix
         * @return: an integer
         */
        static int[] dr = {1,-1,0,0};
        static int[] dc = {0,0,1,-1};
        public int numIslands(boolean[][] grid) {
            // write your code here
            int sum =0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == true){
                        dfs(grid, i, j);
                        sum++;
                    }
                }
            }
            return sum;
        }
        public static void dfs(boolean[][] grid,int x, int y){
            grid[x][y] = false;
            int a;
            int b;
            for(int i=0;i<dc.length;i++){
                a = x + dr[i];
                b = y + dc[i];
                if(can(grid, a,b)){
                    dfs(grid,a,b);
                }
            }

        }
        public static boolean can(boolean[][] grid, int a, int b){
            return a>=0 && a<grid.length && b>=0 && b<grid[0].length && grid[a][b] == true;
        }
    }
}
