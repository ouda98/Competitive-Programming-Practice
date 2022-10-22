package Algorithms;

public class FloodFill {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char c = ' ';
    static int count = 0;
    static int columns;
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < dc.length; i++) {
            newX = x + dr[i];
            newY = (y + dc[i]) % columns;

            if(newY==-1)
                newY = columns-1;
            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY]==c){
                count++;
                dfs(newX,newY);
            }

        }
    }
}
