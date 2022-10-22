public class IslandPerimeter {
    public static void main(String[] args) {

    }
    static int[] left = new int[] {1,0,-1, 0};
    static int[] right = new int[]{0,1, 0,-1};
    public int islandPerimeter(int[][] grid) {
        // Write your code here
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] ==1){
                    for(int k =0;k<left.length;k++){
                        if(!valid(i,j,k, grid) || (valid(i,j,k,grid) && grid[left[k]+i][right[k]+j] == 0)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public boolean valid(int i,int j, int k, int[][] grid){
        return (i+left[k]>=0 && i+left[k]<grid.length && j+right[k]>=0 && j+right[k]< grid[i].length);
    }
}
