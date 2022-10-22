package CP_4_2_5_TopologicalSort;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class OrderingTasks_UVa10305 {
    static LinkedList<Integer>[] grid;
    static boolean[] visited;
    static int count = 0;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/CP_4_2_5/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while(sc.ready()){
            int nodes = sc.nextInt()+1;
            int edges = sc.nextInt();
            if(nodes == 1 && edges==0)
                break;
            grid = new LinkedList[nodes];
            visited = new boolean[nodes];
            for(int i=0;i<nodes;i++)
                grid[i] = new LinkedList<>();

            for(int i=0;i<edges;i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                grid[from].add(to);
            }
//            for(int i=0;i<nodes;i++)
//                System.out.println(grid[i]);

            for(int i=1;i<grid.length;i++){
                if(!visited[i])
                    dfs(i);
            }
            if(!stack.isEmpty())
                System.out.print(stack.pop());
            while(!stack.isEmpty()){
                    System.out.print(" "+stack.pop());
            }

            System.out.println();

        }

        out.flush();
        out.close();
    }

    private static void dfs(int x) {
        visited[x] = true;
        int next;
        for (int i = 0; i < grid[x].size(); i++) {
            next = grid[x].get(i);

            if(!visited[next])
                dfs(next);

        }
        stack.add(x);

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




