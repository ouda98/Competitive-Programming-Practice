package DynamicProgramming;

import java.util.HashMap;

public class MinimumPathSum {

    public static void main(String[] args) {
        int [][] grid = {{7,4,8,7,9,3,7,5,0},
                         {1,8,2,2,7,1,4,5,7},
                         {4,6,4,7,7,4,8,2,1},
                         {1,9,6,9,8,2,9,7,2},
                         {5,5,7,5,8,7,9,1,4},
                         {0,7,9,9,1,5,3,9,4}};
        int r = minPathSum(grid);
        System.out.println(r);
    }
    static HashMap<String,Integer> dp;
    public static int minPathSum(int[][] grid) {
        // write your code here
        dp = new HashMap<>();
        return findMin(grid, grid.length-1,grid[0].length-1,grid[grid.length-1][grid[0].length-1]);
    }

    public static int findMin(int[][] grid, int x, int y, int sum){
        if(x == 0 && y==0)
            return sum;
        if(dp.containsKey(x+" "+y+" "+sum))
            return dp.get(x+" "+y+" "+sum);
        int up = -1;
        int left = -1;
        if(x>0)
            up = findMin(grid, x-1, y, sum + grid[x-1][y]);
        if(y>0)
            left = findMin(grid, x, y-1, sum + grid[x][y-1]);

        int min;
        if(up!=-1 && left!=-1)
            min = Math.min(up,left);
        else if(up!=-1)
            min = up;
        else
            min = left;
        dp.put(x+" "+y+" "+sum,min);
        return min;
    }
}
