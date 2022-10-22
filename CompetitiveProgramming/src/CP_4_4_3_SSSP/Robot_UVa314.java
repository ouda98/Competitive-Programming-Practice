package CP_4_4_3_SSSP;
import java.io.*;
import java.util.*;

public class Robot_UVa314 {
    static int rows, columns;
    static int[][] grid;
    static HashMap<Character, Integer> map;
    static int[][][] dist;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] arr = {1, 2, 3, 2};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        map = new HashMap<>();
        map.put('n', 0);
        map.put('e', 1);
        map.put('s', 2);
        map.put('w', 3);

        while ((rows = sc.nextInt()) != 0 && (columns = sc.nextInt()) != 0) {
            dist = new int[rows][columns][4];
            grid = new int[rows][columns];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = sc.nextInt();
                    for (int k = 0; k < 4; k++)
                        dist[i][j][k] = Integer.MAX_VALUE;
                }


            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            int dir = map.get(sc.next().charAt(0));

            Queue<Triple> queue = new LinkedList<>();

            dist[sx][sy][dir] = 0;
            queue.add(new Triple(sx, sy, dir));
            while (!queue.isEmpty()) {
                Triple top = queue.poll();
                if (top.x == ex && top.y == ey)
                    break;

                int newX, newY, newDirection;

                for (int i = 0; i < 4; ++i) {
                    newDirection = (top.direction + i) % 4;
                    for (int j = 1; j <= 3; ++j) {
                        newX = top.x + dr[newDirection] * j;
                        newY = top.y + dc[newDirection] * j;
                        if (safe(newX, newY) && dist[top.x][top.y][top.direction] + arr[i] <= dist[newX][newY][newDirection]) {
                            dist[newX][newY][newDirection] = dist[top.x][top.y][top.direction] + arr[i];
                            queue.offer(new Triple(newX, newY, newDirection));
                        } else
                            break;
                    }
                }



            }
            int min =Integer.MAX_VALUE;
            for(int i=0;i< dist[ex][ey].length;i++){
                if(dist[ex][ey][i]<min)
                    min = dist[ex][ey][i];
            }
            System.out.println(min== Integer.MAX_VALUE?-1:min);
        }


        out.flush();
        out.close();
    }


    private static boolean safe(int x, int y) {
        int[] dr = {0, 0, -1, -1};
        int[] dc = {0, -1, -1, 0};
        for (int i = 0; i < dr.length; i++) {
            int newX = x + dr[i];
            int newY = y + dc[i];
            if (newX < 0 || newY < 0 || newX >= rows || newY >= columns || grid[newX][newY] == 1)
                return false;
        }
        return true;
    }

    static class Triple {
        int x;
        int y;
        int direction;

        public Triple(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public String toString() {
            return x + " " + y + " " + map.get(direction);
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


