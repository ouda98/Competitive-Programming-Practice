package CP_4_4_3_SSSP;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ThePartyPartI_UVa10959 {
    static LinkedList<Integer> [] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        boolean f = false;
        while(cases-->0){
            if(f)
                out.println();
            f= true;
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            adjList = new LinkedList[nodes];
            for(int i=0;i< adjList.length;i++)
                adjList[i] = new LinkedList<>();
            for(int i=0;i<edges;i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                adjList[from].add(to);
                adjList[to].add(from);
            }


            Queue<Integer> queue = new LinkedList<>();
            int[] dis = new int[nodes];
            boolean [] visited = new boolean[nodes];
            visited[0]= true;
            queue.add(0);
            dis[0]=0;
            while(!queue.isEmpty()){
                int top = queue.poll();
                for(int i =0;i<adjList[top].size();i++){
                    if(!visited[adjList[top].get(i)]){
                        visited[adjList[top].get(i)] = true;
                        queue.add(adjList[top].get(i));
                        dis[adjList[top].get(i)] = dis[top]+1;
                    }
                }
            }
            for(int i=1;i<dis.length;i++)
                out.println(dis[i]);

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


