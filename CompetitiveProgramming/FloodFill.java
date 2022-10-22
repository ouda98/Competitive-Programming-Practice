public class FloodFill {
    public static void main(String[] args) {

    }

    public class Solution {

        static int[] dr = {0, 0, 1, -1};
        static int[] dc = {1, -1, 0, 0};
        static boolean[][] visited;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            // Write your code here
            visited = new boolean[image.length][image[0].length];
            int old = image[sr][sc];
            image[sr][sc] = newColor;
            dfs(image, sr, sc, newColor, old);
            return image;
        }

        public static void dfs(int[][] image, int x, int y, int newColor, int old) {
            visited[x][y] = true;
            int newX, newY;
            for (int i = 0; i < dr.length; i++) {
                newX = x + dr[i];
                newY = y + dc[i];
                if (valid(image, newX, newY) && image[newX][newY] == old && !visited[newX][newY]) {
                    image[newX][newY] = newColor;
                    dfs(image, newX, newY, newColor, old);
                }
            }
        }

        public static boolean valid(int[][] image, int x, int y) {
            return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
        }
    }
}
