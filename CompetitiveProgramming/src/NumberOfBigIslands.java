public class NumberOfBigIslands {
    public static void main(String[] args) {

    }
    static int count;
    static int[] h = new int[]{0,1,0,-1};
    static int[] v = new int[]{1,0,-1,0};
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        count = 0;
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == true){
                    count++;
                    grid[i][j] = false;
                    dfs(i,j,grid);
                    if(count>=k)
                        sum++;
                }
                count=0;
            }
        }
        return sum;
    }
    public void dfs(int x, int y, boolean[][] grid){
        for(int i=0;i<h.length;i++){
            if(valid(x,y,h[i],v[i],grid)){
                count++;
                grid[x+h[i]][y+v[i]] = false;
                dfs(x+h[i],y+v[i],grid);
            }
        }
    }
    public boolean valid(int x, int y, int i, int j, boolean[][] grid){
        return x+i>=0 && x+i < grid.length && y+j >=0 && y+j<grid[x+i].length && grid[i+x][y+j] ==true;
    }
}
