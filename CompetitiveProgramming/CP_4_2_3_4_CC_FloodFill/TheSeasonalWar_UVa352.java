package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class TheSeasonalWar_UVa352 {
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int c=0;
        while (sc.ready()) {
            c++;
            int dimensions = sc.nextInt();
            int counter = 0;
            grid = new int[dimensions][dimensions];
            visited = new boolean[dimensions][dimensions];
            for (int i = 0; i < grid.length; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    grid[i][j] = line.charAt(j)-'0';
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
//                    System.out.println("here "+grid[i][j]);
                    if (grid[i][j] == 1 && !visited[i][j]) {
//                        System.out.println(counter);
                        counter++;
                        dfs(i, j);
                    }
                }

            }
            System.out.println("Image number "+c+" contains "+counter+" war eagles.");
        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < dr.length; i++) {

            newX = x + dr[i];
            newY = y + dc[i];

            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid.length && grid[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }


    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}

