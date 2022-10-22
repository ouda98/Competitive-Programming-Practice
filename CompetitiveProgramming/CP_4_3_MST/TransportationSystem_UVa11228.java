package CP_4_3_MST;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TransportationSystem_UVa11228 {
    static LinkedList<Pair> []adjList;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        int c=1;
        while(cases-->0){
            int nodes = sc.nextInt();
            int r = sc.nextInt();
            adjList = new LinkedList[nodes];
            for(int i=0;i<adjList.length;i++){
                adjList[i] = new LinkedList<>();
            }
            points = new Point[nodes];
            for(int i=0;i<nodes;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[i] = new Point(x,y);
                for(int j=0;j<i;j++){
                    int prevX = points[j].x;
                    int prevY = points[j].y;
                    double distance = Math.sqrt(Math.pow(prevX-x,2)+Math.pow(prevY-y,2));
                    adjList[j].add(new Pair(i,distance));
                    adjList[i].add(new Pair(j,distance));
                }
            }
//            for(int i=0;i< adjList.length;i++){
//                System.out.println(adjList[i]);
//            }
            boolean [] visited = new boolean[nodes];
            visited[0]= true;
            int count =0;
            int e=0;
            double sumShort = 0;
            double sumLong =0;
            int states = 1;
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            while(e<nodes-1){
//                System.out.println(e);
                for(int i=0;i<adjList[count].size();i++){
                    queue.add(adjList[count].get(i));
                }
                while(!queue.isEmpty()) {

                    Pair top = queue.poll();
//                    System.out.println(queue);
//                    System.out.println(top);

                    if (!visited[top.to]) {
                        count = top.to;
//                        System.out.println(count);
                        e++;
                        visited[count] = true;
                        if (top.weight >= r) {
                            states++;
                            sumLong += top.weight;
                        } else
                            sumShort += top.weight;
                        break;
                    }
                }

            }
            System.out.println("Case #"+c+++": "+states +" "+ Math.round(sumShort)+ " " + Math.round(sumLong));

        }
        out.flush();
        out.close();
    }
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return  x+" "+ y;
        }
    }
    static class Pair implements Comparable{
        int to;
        double weight;
        public Pair(int to,double weight){
            this.to = to;
            this.weight = weight;
        }
        public String toString(){
            return  to+" "+ weight;
        }

        @Override
        public int compareTo(Object o) {
            if(this.weight== ((Pair)o).weight){
                return this.to - ((Pair)o).to;
            }
            return Double.compare(this.weight, ((Pair)o).weight);
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



