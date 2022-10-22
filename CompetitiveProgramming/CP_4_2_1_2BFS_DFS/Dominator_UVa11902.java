package CP_4_2_1_2BFS_DFS;

import java.io.*;
import java.util.*;

public class Dominator_UVa11902 {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int counter = 1;
    static HashSet<Integer> reachable = new HashSet<>();
    static HashSet<Integer> reachableStart = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP4_2_1_2/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int dimensions = sc.nextInt();
            adjList = new LinkedList[dimensions];
            visited = new boolean[dimensions];
            for (int j = 0; j < adjList.length; j++)
                adjList[j] = new LinkedList<>();
            for (int j = 0; j < dimensions; j++) {
                String[] line = sc.nextLine().split(" ");
                for (int k = 0; k < line.length; k++) {
                    if (line[k].equals("1"))
                        adjList[j].add(k);
                }
            }
            out.println("Case "+(i+1)+":");
            StringBuilder border = new StringBuilder();
            border.append("+");
            for(int j=0;j<(2*dimensions)-1;j++){
                border.append("-");
            }
            border.append("+");
            out.println(border);
            dfsStart(0);
            StringBuilder sb = new StringBuilder();
            sb.append("|");

            for(int j=0;j< adjList.length;j++){
                if(reachableStart.contains(j))
                    sb.append("Y|");
                else
                    sb.append("N|");
            }
            out.println(sb);
            out.println(border);
            Arrays.fill(visited, false);
            for (int j = 1; j < adjList.length; j++) {
                visited[j] = true;
                dfs(0);
                sb = new StringBuilder();
                sb.append("|");
                for(int k=0;k< adjList.length;k++){
                    if(reachableStart.contains(k) && !reachable.contains(k))
                        sb.append("Y|");
                    else
                        sb.append("N|");
                }
                out.println(sb.toString());
                out.println(border);
                Arrays.fill(visited, false);
                reachable.clear();
            }
            reachableStart.clear();


        }
        out.flush();
        out.close();
    }

    private static void dfs(Integer key) {
        visited[key] = true;
        reachable.add(key);

        LinkedList<Integer> list = adjList[key];
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void dfsStart(Integer key) {
        visited[key] = true;
        reachableStart.add(key);
        LinkedList<Integer> list = adjList[key];
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                dfsStart(i);
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

