package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.*;

public class ForwardingEmails_UVa12442 {
    static int[] adjList;
    static boolean[] visited;
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int lines = sc.nextInt();
            visited = new boolean[lines+1];
            adjList = new int[lines+1];
            for (int j = 0; j < lines; j++) {
                adjList[sc.nextInt()] = sc.nextInt();
            }
            int candidate = -1;
            int maxReach = -1;
            for (int j = 0; j < adjList.length; j++) {
                Arrays.fill(visited, Boolean.FALSE);
                dfs(j);
                if (counter > maxReach) {
                    candidate = j;
                    maxReach = counter;
                }
                counter = 0;
            }
            out.println("Case " + (i + 1) + ": " + candidate);
        }

        out.flush();
        out.close();


    }

    private static void dfs(int key) {

        visited[key] = true;
        int i = adjList[key];
        if (!visited[i]) {
            counter++;
            visited[i] = true;
            dfs(i);
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
