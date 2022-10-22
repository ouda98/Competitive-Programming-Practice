package CP_4_4_3Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MiceAndMaze_UVa1112 {
    static LinkedList<Pair> [] adjList;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        boolean f = false;
        while(cases-->0){
            if(f)
                out.println();
            f = true;
            int nodes = sc.nextInt()+1;
            int existCell = sc.nextInt();
            int timeOut = sc.nextInt();
            int lines = sc.nextInt();
            adjList = new LinkedList[nodes];
            for(int i=0;i< adjList.length;i++)
                adjList[i] = new LinkedList<>();
            for(int i=0;i<lines;i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int weight = sc.nextInt();
                adjList[to].add(new Pair(from,weight));
            }

            int[] dist = new int[adjList.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            Arrays.fill(dist,(int)1e9);
            dist[existCell]=0;
            pq.add(new Pair(existCell,0));

            while(!pq.isEmpty()){
                Pair top = pq.poll();
                if(dist[top.to]<top.weight)
                    continue;
                Pair nx;
                for(int i=0;i< adjList[top.to].size();i++){
                    nx = adjList[top.to].get(i);
                    if(dist[top.to]+ nx.weight < dist[nx.to]){
                        dist[nx.to] = dist[top.to]+ nx.weight;
                        pq.add(new Pair(nx.to,dist[nx.to]));
                    }
                }
            }
            int c =0;
            for(int i=0;i<dist.length;i++){
                if(dist[i]<= timeOut)
                    c++;
            }
            out.println(c);



        }


        out.flush();
        out.close();
    }
    static class Pair implements Comparable{
        int to;
        int weight;
        public Pair(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
        public String toString(){
            return to+" "+weight;
        }

        @Override
        public int compareTo(Object o) {
            if(this.weight == ((Pair)o).weight)
                return this.to - ((Pair)o).to;
            return this.weight - ((Pair)o).weight;
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


