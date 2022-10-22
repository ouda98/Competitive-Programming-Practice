import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    public static void main(String[] args) {

    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public class Solution {
        /**
         * @param grid: a chessboard included 0 (false) and 1 (true)
         * @param source: a point
         * @param destination: a point
         * @return: the shortest path
         */
        static int[] dr = {1, 1, -1, -1, 2, 2, -2, -2};
        static int[] dc = {2, -2, 2, -2, 1, -1, 1, -1};

        public int shortestPath(boolean[][] grid, Point source, Point destination) {
            // write your code here
            if (grid[source.x][source.y] == true || grid[destination.x][destination.y] == true)
                return -1;
            if (source.x == destination.x && source.y == destination.y)
                return 0;
            Queue<Triple> q = new LinkedList<>();
            q.add(new Triple(source.x, source.y, 0));
            grid[source.x][source.y] = true;
            while (!q.isEmpty()) {
                Triple top = q.poll();
                int x, y;
                for (int i = 0; i < dr.length; i++) {
                    x = top.x + dr[i];
                    y = top.y + dc[i];
                    if (can(grid, x, y)) {
                        grid[x][y] = true;
                        q.add(new Triple(x, y, top.distance + 1));
                        if (x == destination.x && y == destination.y)
                            return top.distance + 1;
                    }
                }
            }
            return -1;
        }

        public static boolean can(boolean[][] grid, int x, int y) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == false;
        }

        public static class Triple {
            int x;
            int y;
            int distance;

            public Triple(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }

    }
}
