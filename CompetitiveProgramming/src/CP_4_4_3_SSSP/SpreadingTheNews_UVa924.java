package CP_4_4_3_SSSP;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpreadingTheNews_UVa924 {
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int nodes = sc.nextInt();
        adjList = new LinkedList[nodes];
        for (int i = 0; i < adjList.length; i++)
            adjList[i] = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int to = sc.nextInt();
                adjList[i].add(to);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes];
        int dis[] = new int[nodes];
        int q = sc.nextInt();
        for (int j = 0; j < q; j++) {
            for (int i = 0; i < nodes; i++) {
                visited[i] = false;
                dis[i] = -1;
            }
            int src = sc.nextInt();
            visited[src] = true;
            queue.add(src);
            dis[src] = 0;
            int limit = 1;
            int counter = 0;
            int max = 0;
            int day = 0;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                if (dis[top] == limit) {
                    if (counter > max) {
                        max = counter;
                        day = limit;
                    }

                    counter = 0;
                    limit++;

                }
                for (int i = 0; i < adjList[top].size(); i++) {
                    if (!visited[adjList[top].get(i)]) {
                        counter++;
                        visited[adjList[top].get(i)] = true;
                        dis[adjList[top].get(i)] = dis[top] + 1;
                        queue.add(adjList[top].get(i));
                    }
                }
            }
            if (max == 0)
                System.out.println(0);
            else
                System.out.println(max + " " + day);
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



