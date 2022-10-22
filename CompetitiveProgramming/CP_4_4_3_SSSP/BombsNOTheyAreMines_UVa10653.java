package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class BombsNOTheyAreMines_UVa10653 {
    static boolean [][] grid;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};
    static int rows, columns=0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while((rows = sc.nextInt())!=0 | (columns = sc.nextInt())!=0){
        grid = new boolean[1000][1000];

        int bomb = sc.nextInt();
        for (int i = 0; i < bomb; i++) {
            int row = sc.nextInt();
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                grid[row][sc.nextInt()] = true;
            }
        }
        int sX = sc.nextInt();
        int sY = sc.nextInt();
        int[][] dis = new int[1000][1000];
        Queue<Point> queue = new LinkedList<>();

        dis[sX][sY] = 0;
        grid[sX][sY] = true;
        queue.add(new Point(sX, sY));
            int desX = sc.nextInt();
            int desY = sc.nextInt();
        while (!queue.isEmpty()) {
            Point top = queue.poll();
            int x = top.x;
            int y = top.y;
            if(desX ==x && desY==y)
                break;
            for (int i = 0; i < dc.length; i++) {
                int newX = x + dr[i];
                int newY = y + dc[i];
                if (newX>=0 && newY>=0 && newX<rows && newY<columns && !grid[newX][newY]) {
                    grid[newX][newY] = true;
                    dis[newX][newY] = dis[x][y] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        out.println(dis[desX][desY]);
        }



        out.flush();
        out.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
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


