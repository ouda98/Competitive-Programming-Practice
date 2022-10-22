package CP_4_2_3_4_CC_FloodFill;

import java.io.*;
import java.util.*;

public class WetlandsOfFlorida_UVa469 {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_3_4/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        sc.nextLine();
        grid = new char[101][101];
        visited = new boolean[101][101];
        for (int i = 0; i < cases; i++) {

            for (int j = 0; j < grid.length; j++)
                for (int k = 0; k < grid[j].length; k++)
                    grid[j][k] = '.';

            int counter = 0;
            while (true) {

                String line = sc.nextLine();

                if (line == null || line.length() == 0) {
                    break;
                }
                String[] l = line.split(" ");
                if (Character.isDigit(line.charAt(0)) && l.length == 2) {
                    for (int j = 0; j < visited.length; j++)
                        Arrays.fill(visited[j], false);
                    int x = Integer.parseInt(l[0]) - 1;
                    int y = Integer.parseInt(l[1]) - 1;
                    count = 1;
                    dfs(x, y);
                    System.out.println(count);
                }else{
                    for (int j = 0; j < line.length(); j++) {
                        grid[counter][j] = line.charAt(j);
                    }
                    counter++;
                }
            }
            if(i!=cases-1)
                System.out.println();


        }
        out.flush();
        out.close();
    }

    private static void dfs(int x, int y) {
        if (grid[x][y] == 'W' && !visited[x][y]) {
            visited[x][y] = true;
            int newX;
            int newY;
            for (int i = 0; i < dr.length; i++) {

                newX = x + dr[i];
                newY = y + dc[i];

                if (newX >= 0 && newY >= 0 && newX < 101 && newY < 101 && grid[newX][newY] == 'W' && !visited[newX][newY]) {
                    count++;
                    dfs(newX, newY);
                }
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

