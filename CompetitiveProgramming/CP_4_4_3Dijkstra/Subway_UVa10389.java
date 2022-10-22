package CP_4_4_3Dijkstra;

import java.io.*;
import java.util.*;

public class Subway_UVa10389 {
    static LinkedList<Pair>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        boolean f = false;
        while (cases-->0) {
            if(f)
                System.out.println();
            f = true;

            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int schoolX = sc.nextInt();
            int schoolY = sc.nextInt();
            ArrayList<Point> nodes = new ArrayList<>();
            nodes.add(new Point(startX, startY, 0));
            nodes.add(new Point(schoolX, schoolY, 1));

            int x, y;
            int count = 2;
            while (sc.ready()) {
                String l = sc.nextLine();
                if(l==null || l.length()==0)
                    break;
                String[] line = l.split(" ");
                for(int i=0;i<line.length-2;i+=2)
                    nodes.add(new Point(Integer.parseInt(line[i]), Integer.parseInt(line[i+1]), count));


                count++;
            }

            adjList = new LinkedList[nodes.size()];
            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new LinkedList<>();
            for (int i = 0; i < nodes.size(); i++) {
                Point top = nodes.get(i);
                for (int j = 0; j < i; j++) {
                    Point old = nodes.get(j);
                    double distance = Math.sqrt((top.x - old.x) * (top.x - old.x) + (top.y - old.y) * (top.y - old.y));
                    if (old.subway == top.subway) {
                        distance = distance / (40000.0 / 60.0);
                    } else
                        distance = distance / (10000.0 / 60.0);

                    if((old.subway == top.subway && Math.abs(j-i)==1) || (old.subway != top.subway)){
                        adjList[i].add(new Pair(j, distance));
                        adjList[j].add(new Pair(i, distance));
                    }
                }
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            double[] dist = new double[nodes.size()];

            Arrays.fill(dist, (int) 1e8);
            pq.add(new Pair(0, 0));
            dist[0] = 0;

            while (!pq.isEmpty()) {
                Pair top = pq.poll();
                if(top.to == 1)break;
                if (dist[top.to] < top.weight)
                    continue;
                Pair nx;
                for (int i = 0; i < adjList[top.to].size(); i++) {
                    nx = adjList[top.to].get(i);
                    if ((dist[top.to] + nx.weight) < dist[nx.to]) {
                        dist[nx.to] = dist[top.to] + nx.weight;
                        pq.add(new Pair(nx.to, dist[nx.to]));
                    }
                }
            }
            System.out.println(Math.round(dist[1]));
        }




        out.flush();
        out.close();
    }

    static class Pair implements Comparable{
        int to;
        double weight;

        public Pair(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return to + " " + weight;
        }

        @Override
        public int compareTo(Object o) {
            if (this.weight == ((Pair) o).weight)
                return this.to - ((Pair) o).to;
            return Double.compare(this.weight, ((Pair) o).weight);
        }
    }

    static class Point {
        int x;
        int y;
        int subway;

        public Point(int x, int y, int subway) {
            this.x = x;
            this.y = y;
            this.subway = subway;
        }

        public String toString() {
            return x + " " + y+" "+subway;
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



