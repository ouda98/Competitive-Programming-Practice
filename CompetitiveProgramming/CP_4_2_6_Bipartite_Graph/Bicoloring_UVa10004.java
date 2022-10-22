package CP_4_2_6_Bipartite_Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bicoloring_UVa10004 {
    static LinkedList<Integer>[] grid;
    static int[] color;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Queue<Integer> queue = new LinkedList<>();
        boolean flag = true;
        while(sc.ready()) {
            int nodes = sc.nextInt();
            if(nodes==0)break;
            int edges = sc.nextInt();
            flag = true;

            grid = new LinkedList[nodes];
            for (int i = 0; i < grid.length; i++) {
                grid[i] = new LinkedList<>();
            }
            color = new int[nodes];
            Arrays.fill(color, -1);
            queue.clear();

            for (int i = 0; i < edges; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                grid[from].add(to);
                grid[to].add(from);

            }

            color[0] = 1;
            queue.add(0);

            while (queue.size() != 0) {
                int vertex = queue.poll();

                for (int i = 0; i < grid[vertex].size(); i++) {

                    int top = grid[vertex].get(i);
                    //                        System.out.println(vertex+" "+top+" "+color[vertex]+" "+color[top]);
                    if (color[top] == -1){
                        color[top] = 1 - color[vertex];
                        queue.add(top);
                    }

                    else if (color[vertex] == color[top]) {
                        flag = false;
                        break;
                    }

                }
            }

            if (!flag)
                System.out.println("NOT BICOLORABLE.");
            else
                System.out.println("BICOLORABLE.");


        }


        out.flush();
        out.close();
    }

    private static void dfs(int x) {

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


