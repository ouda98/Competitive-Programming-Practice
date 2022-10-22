package CP_4_4_3Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NumberMaze_UVa929 {
    static int[][] grid;
    static int[] dc = {0, 0, 1, -1};
    static int[] dr = {1, -1, 0, 0};
    static int rows, columns;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            rows = sc.nextInt();
            columns = sc.nextInt();
            grid = new int[rows][columns];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    grid[i][j] = sc.nextInt();

            int[][] dist = new int[rows][columns];
            for (int i = 0; i < dist.length; i++)
                Arrays.fill(dist[i], (int) 1e9);
            PriorityQueue<Triple> pq = new PriorityQueue<>();
            dist[0][0] = grid[0][0];
            pq.add(new Triple(0, 0, grid[0][0]));

            while (!pq.isEmpty()) {
                Triple top = pq.poll();

                if (dist[top.x][top.y] < top.weight) {
                    continue;
                }

                int nx, ny;
                for (int i = 0; i < dr.length; i++) {
                    nx = top.x + dr[i];
                    ny = top.y + dc[i];
                    if (valid(nx, ny) && (dist[top.x][top.y] + grid[nx][ny]) < dist[nx][ny]) {
                        dist[nx][ny] = dist[top.x][top.y] + grid[nx][ny];
                        pq.add(new Triple(nx, ny, dist[nx][ny]));
                    }
                }

            }
            out.println(dist[rows - 1][columns - 1]);

        }

        out.flush();
        out.close();
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }

    static class Triple implements Comparable {
        int x;
        int y;
        int weight;

        public Triple(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public String toString() {
            return x + " " + y + " " + weight;
        }

        @Override
        public int compareTo(Object o) {
            if (this.weight == ((Triple) o).weight)
                if (this.x == ((Triple) o).x)
                    return this.y - ((Triple) o).y;
                else
                    return this.x - ((Triple) o).x;

            return this.weight - ((Triple) o).weight;
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


