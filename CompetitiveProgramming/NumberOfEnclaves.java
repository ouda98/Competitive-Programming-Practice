public class NumberOfEnclaves {
    public static void main(String[] args) {

    }
    static int[] r = new int[]{0,0,1,-1};
    static int[] c = new int[]{1,-1,0,0};
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid[0].length;i++)
            if(grid[0][i] ==1){
                grid[0][i] =0;
                dfs(0,i,grid);
            }
        for(int i=0;i<grid[grid.length-1].length;i++)
            if(grid[grid.length-1][i] ==1){
                grid[grid.length-1][i] =0;
                dfs(grid.length-1,i,grid);
            }
        for(int i=0;i<grid.length;i++)
            if(grid[i][0] ==1){
                grid[i][0] =0;
                dfs(i,0,grid);
            }
        for(int i=0;i<grid.length;i++)
            if(grid[i][grid[i].length-1] == 1){
                grid[i][grid[i].length-1] = 0;
                dfs(i,grid[i].length-1,grid);
            }
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++)
                count+= grid[i][j] == 1?1:0;
        }
        return count;
    }
    public void dfs(int x, int y, int[][] grid){
        for(int i=0;i<r.length;i++){
            if(isValid(x+r[i],y+c[i],grid)){
                grid[x+r[i]][y+c[i]] = 0;
                dfs(x+r[i],y+c[i], grid);
            }
        }
    }
    public boolean isValid(int x, int y, int [][] grid){
        return x>=0 && y>=0 && x< grid.length && y< grid[x].length && grid[x][y] == 1;
    }
}
