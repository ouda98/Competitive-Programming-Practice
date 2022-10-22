import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {

    }

    public class Solution {
        /**
         * @param grid: a list of lists of integers
         * @return: return an integer, denote the number of distinct islands
         */
        static int[] dr = {0, 0, 1, -1};
        static int[] dc = {1, -1, 0, 0};
        static StringBuilder sb;

        public int numberofDistinctIslands(int[][] grid) {
            // write your code here
            sb = new StringBuilder();
            HashSet<String> set = new HashSet<>();
            int counter = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        sb.append("1");
                        dfs(grid, i, j);
                        set.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }
            return set.size();
        }

        public static void dfs(int[][] grid, int x, int y) {
            grid[x][y] = 0;
            int newX, newY;
            for (int i = 0; i < dr.length; i++) {
                newX = x + dr[i];
                newY = y + dc[i];
                sb.append(".");
                if (can(grid, newX, newY)) {
                    grid[newX][newY] = 0;
                    sb.append(dr[i] + "" + dc[i]);
                    dfs(grid, newX, newY);
                }
            }
        }

        public static boolean can(int[][] grid, int x, int y) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1;
        }
    }
}
