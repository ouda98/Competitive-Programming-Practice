package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class ContourPainting_UVa00782 {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxCount = 0;
    static int c = 0;
    static int lastLine = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        int x = 0;
        int y = 0;
        for (int k = 0; k < cases; k++) {
            grid = new char[31][81];
            visited = new boolean[31][81];
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(grid[i], ' ');
            }
            String dashes = "";
            for (int i = 0; i < grid.length; i++) {
                String line = sc.nextLine();
                if (line == null || line.length() == 0) {

                    continue;
                }

                if (line.charAt(0) == '_'){
                    dashes = line;
                    lastLine = i;
                    break;
                }

                for (int j = 0; j < line.length(); j++) {
                    grid[i][j] = line.charAt(j);
                    if (line.charAt(j) == '*') {
                        x = i;
                        y = j;
                        grid[i][j] = ' ';
                    }
                }
            }
            dfs(x, y);

            for (int i = 0; i < lastLine; i++) {
                String str = String.valueOf(grid[i]);
                out.println(trimEnd(str));
            }
            out.println(dashes);
        }

        out.flush();
        out.close();
    }
    static public String trimEnd(String value) {
        int len = value.length();
        int st = 0;
        while ((st < len) && value.charAt(len - 1) == ' ') {
            len--;
        }
        return value.substring(0, len);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int newX;
        int newY;
        for (int i = 0; i < dr.length; i++) {
            newX = x + dr[i];
            newY = y + dc[i];
            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                if (grid[newX][newY] == 'X')
                    grid[x][y] = '#';
                else if (grid[newX][newY] == ' ')
                    dfs(newX, newY);
            }
        }


    }

    static class Pair implements Comparable<Pair> {
        int x;
        char y;

        public Pair(char y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if (Integer.compare(p.x, this.x) == 0)
                return Character.compare(this.y, p.y);
            return Integer.compare(p.x, this.x);
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


