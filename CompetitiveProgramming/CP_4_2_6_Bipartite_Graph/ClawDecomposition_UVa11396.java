package CP_4_2_6_Bipartite_Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition_UVa11396 {
    static LinkedList<Integer>[] grid;
    static int[] color;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Queue<Integer> queue = new LinkedList<>();

        while (sc.ready()) {
            boolean flag = true;
            int nodes = sc.nextInt();
            if (nodes == 0) break;

            grid = new LinkedList[nodes + 1];
            for (int i = 0; i < grid.length; i++) {
                grid[i] = new LinkedList<>();
            }
            color = new int[nodes + 1];
            Arrays.fill(color, -1);
            queue.clear();
            while (true) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                if (from == 0 && to == 0)
                    break;
                grid[from].add(to);
                grid[to].add(from);

            }
            color[1] = 1;
            queue.add(1);
            while (queue.size() != 0) {
                int vertex = queue.poll();
                for (int i = 0; i < grid[vertex].size(); i++) {

                    int top = grid[vertex].get(i);
                    if (color[top] == -1) {
                        color[top] = 1 - color[vertex];
                        queue.add(top);
                    } else if (color[vertex] == color[top]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        out.flush();
        out.close();
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


