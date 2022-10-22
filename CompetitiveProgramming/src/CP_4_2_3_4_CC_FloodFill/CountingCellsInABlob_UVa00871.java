package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class CountingCellsInABlob_UVa00871 {
    static int[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int maxCount = 0;
    static int c = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        sc.nextLine();
        grid = new int[26][26];
        visited = new boolean[26][26];

        for (int k = 0; k < cases; k++) {
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(grid[i], -1);
                Arrays.fill(visited[i], false);
            }
            int count = 0;
            while (true) {
                String line = sc.nextLine();
                if (line == null || line.length() == 0)
                    break;
                for (int i = 0; i < line.length(); i++) {
                    grid[count][i] = line.charAt(i) - '0';
                }
                count++;

            }
            maxCount = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        c = 0;
                        dfs(i, j);
                        if (c > maxCount) {
                            maxCount = c;
                        }

                        c = 0;
                    }

                }
            }
            System.out.println(maxCount);
            if(k<cases-1)
            System.out.println();
        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        c++;
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

