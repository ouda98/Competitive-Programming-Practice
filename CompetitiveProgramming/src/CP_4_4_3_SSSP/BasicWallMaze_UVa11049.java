package CP_4_4_3_SSSP;

import java.io.*;
import java.util.*;

public class BasicWallMaze_UVa11049 {
    static boolean visited[][];
    static HashSet<String> set = new HashSet<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String[][] path;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(0,'S');
        map.put(1,'E');
        map.put(2,'N');
        map.put(3,'W');

        PrintWriter out = new PrintWriter(System.out);
        int sx = 0;
        int sy = 0;
        while ((sy = sc.nextInt()) != 0 && (sx = sc.nextInt()) != 0) {
            sx--;
            sy--;
            int ey = sc.nextInt() - 1;
            int ex = sc.nextInt() - 1;
            set.clear();
            for (int i = 0; i < 3; i++) {
                int fy = sc.nextInt();
                int fx = sc.nextInt();
                int ty = sc.nextInt();
                int tx = sc.nextInt();

                if (fx == tx) {
                    int dif = Math.max(ty, fy) - Math.min(ty, fy);
                    for (int j = 0; j < dif; j++) {
                        set.add(fx + "" + (Math.min(fy, ty) + j) + "" + (fx - 1) + "" + (Math.min(fy, ty) + j));
                        set.add((fx - 1) + "" + (Math.min(fy, ty) + j) + "" + fx + "" + (Math.min(fy, ty) + j));
                    }
                } else if (ty == fy) {
                    int dif = Math.max(tx, fx) - Math.min(tx, fx);
                    for (int j = 0; j < dif; j++) {
                        set.add((Math.min(fx, tx) + j) + "" + fy + "" + (Math.min(fx, tx) + j) + "" + (fy - 1));
                        set.add((Math.min(fx, tx) + j) + "" + (fy - 1) + "" + (Math.min(fx, tx) + j) + "" + fy);
                    }

                }

            }
//            for (String s : set)
//                System.out.println(s);

            Queue<Pair> queue = new LinkedList<>();
            visited = new boolean[6][6];
            path = new String[6][6];
            path[sx][sy]="";
            visited[sx][sy] = true;
            queue.add(new Pair(sx, sy));
            while (!queue.isEmpty()) {
                Pair top = queue.poll();
                int nx;
                int ny;
                for (int i = 0; i < dc.length; i++) {
                    nx = top.x + dr[i];
                    ny = top.y + dc[i];

                    if (nx >= 0 && ny >= 0 && nx < 6 && ny < 6 && !visited[nx][ny] && !set.contains(top.x + "" + top.y + "" + nx + "" + ny)) {
                        visited[nx][ny] = true;
                        path[nx][ny] = path[top.x][top.y]+map.get(i)+"";
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            System.out.println(path[ex][ey]);


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


