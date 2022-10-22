package LintCodeBacktracking;

public class PathWithMaximumGold {
    static int[][]grid;
    static int max;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static boolean [][] visited;
    public static void main(String[] args) {
//        grid = new int[][]{{0,0,34,0,5,0,7,0,0,0},
//                           {0,0,0,0,21,0,0,0,0,0},
//                           {0,18,0,0,8,0,0,0,4,0},
//                           {0,0,0,0,0,0,0,0,0,0},
//                           {15,0,0,0,0,22,0,0,0,21},
//                           {0,0,0,0,0,0,0,0,0,0},
//                           {0,7,0,0,0,0,0,0,38,0}};
        grid = new int[][]{{0,6,0},
                           {5,8,7},
                           {0,9,0}};
        visited = new boolean[grid.length][grid[0].length];

        max =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && !visited[i][j]) {
                    visited[i][j] = true;
                    solve(grid[i][j], i, j);
                }
            }
        }
        System.out.println(max);
    }

    private static void solve(int sum,int x, int y) {
        for(int i=0;i<dr.length;i++){
            int nx = x+dr[i];
            int ny = y+dc[i];

            if(can(nx,ny)) {
                int v = grid[x][y];
                grid[x][y]=0;
                visited[nx][ny]=true;
                solve(sum + grid[nx][ny], nx, ny);
//                grid[x][y]=v;
            }
        }
        if(max<sum)
            max = sum;
    }

    private static boolean can(int nx, int ny) {
        return nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]!=0;
    }
}
