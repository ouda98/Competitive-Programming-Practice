public class MaxAreaOfIsland {
    public static void main(String[] args) {

    }
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static int count;
    public int maxAreaOfIsland(int[][] grid) {
        // Write your code here
        int max = 0;
        count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    dfs(i,j,grid);
                    count++;
                    max = Math.max(count, max);
                    count = 0;
                }
            }
        }
        return max;
    }
    public void dfs(int x, int y, int[][] grid){
        for(int i=0;i<dr.length;i++){
            if(isValid(x,y,dr[i],dc[i],grid)){
                count++;
                grid[x+dr[i]][y+dc[i]] = 0;
                dfs(x+dr[i], y+dc[i], grid);
            }
        }
    }
    public boolean isValid(int x, int y, int i, int j, int[][] grid){
        return x+i>=0 && x+i<grid.length && y+j>=0 && y+j<grid[x+i].length && grid[x+i][y+j] == 1;
    }
}
