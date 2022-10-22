package CP_4_4_3Dijkstra;

import java.io.*;
import java.util.*;

public class Travel_UVa10166 {
    static HashMap<String, Integer> map = new HashMap<>();
    static LinkedList<Pair>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (sc.ready()) {
            map.clear();
            int cities = sc.nextInt();
            if (cities==0)
                break;
            for (int i = 0; i < cities; i++) {
                map.put(sc.nextLine(), i);
            }
            int trains = sc.nextInt();
            adjList = new LinkedList[cities];
            for (int i = 0; i < adjList.length; i++)
                adjList[i] = new LinkedList<>();
            for (int i = 0; i < trains; i++) {
                int stops = sc.nextInt();
                Pair[] s = new Pair[stops];
                for (int j = 0; j < stops; j++) {
                    int arrive = sc.nextInt();
                    int city = map.get(sc.next());
                    for (int k = 0; k < j; k++) {
                        Pair old = s[k];
                        adjList[city].add(old);
                        adjList[old.to].add(new Pair(city, arrive));
                    }
                    s[j] = new Pair(city, arrive);

                }
            }
            int earliest = sc.nextInt();
            int src = map.get(sc.nextLine());
            int dest = map.get(sc.nextLine());

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int[] distance = new int [adjList.length];
            Arrays.fill(distance,(int)1e9);
            pq.add(new Pair(src,0));
            distance[src]= 0;

            while(!pq.isEmpty()){
                Pair top = pq.poll();
                if(dest == top.to)
                    break;
                Pair nx;
                for(int i=0;i< adjList[top.to].size();i++){
                    nx = adjList[top.to].get(i);
                    if(distance[nx.to]>nx.weight){
                        distance[nx.to] = nx.weight;
                        pq.add(new Pair(nx.to,distance[nx.to]));
                    }
                }
            }
            System.out.println(distance[dest]);


        }


        out.flush();
        out.close();
    }



    static class Pair implements Comparable {
        int to;
        int weight;

        public Pair(int to, int weight) {
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
            return Integer.compare(this.weight, ((Pair) o).weight);
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


