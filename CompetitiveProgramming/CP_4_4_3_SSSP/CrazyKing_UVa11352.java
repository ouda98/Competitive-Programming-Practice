package CP_4_4_3_SSSP;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CrazyKing_UVa11352 {
    static boolean[][] visited;
    static int[] horseX = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] horseY = {1, -1, 1, -1, 2, 2, -2, -2};
    static int[] dr = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dc = {1, 0, -1, 0, 1, -1, -1, 1};

    static int rows, columns;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            rows = sc.nextInt();
            columns = sc.nextInt();
            int xA = 0, yA = 0, xB = 0, yB = 0;
            visited = new boolean[rows][columns];
            int[][] dist = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == 'A') {
                        xA = i;
                        yA = j;
                    } else if (line.charAt(j) == 'B') {
                        xB = i;
                        yB = j;
                    } else if (line.charAt(j) == 'Z') {
                        visited[i][j] = true;
                        for (int k = 0; k < horseX.length; k++) {
                            if (valid(i + horseX[k], j + horseY[k]))
                                visited[i + horseX[k]][j + horseY[k]] = true;
                        }
                    }
                }
            }
            visited[xA][yA] = true;
            visited[xB][yB] = false;
            for (int i = 0; i < dist.length; i++)
                Arrays.fill(dist[i], -1);

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(xA, yA));
            dist[xA][yA] = 0;
            while (!queue.isEmpty()) {
                Pair top = queue.poll();
                if (top.x == xB && top.y == yB)
                    break;
                int nx, ny;
                for (int i = 0; i < dc.length; i++) {
                    nx = top.x + dr[i];
                    ny = top.y + dc[i];
                    if (valid(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[top.x][top.y] + 1;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            if (dist[xB][yB] == -1)
                System.out.println("King Peter, you can't go now!");
            else
                System.out.println("Minimal possible length of a trip is "+dist[xB][yB]);

        }


        out.flush();
        out.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
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



