package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ImplementingDijkstraAlgorithm {
    public static void main(String[] args) {

    }
    public static class Pair implements Comparable{
        int v;
        int d;
        public Pair(int v, int d){
            this.v = v;
            this.d = d;
        }
        public int compareTo(Object o){
            if(Integer.compare(this.d, ((Pair)o).d) == 0)
                return Integer.compare(this.v, ((Pair)o).v);
            return Integer.compare(this.d, ((Pair)o).d);

        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dis = new int[V];
        Arrays.fill(dis,1000000);
        dis[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(S,0));
        Pair p;
        while(!pq.isEmpty()){
            p = pq.poll();
            if(p.d>dis[p.v])
                continue;
            for(ArrayList<Integer> a : adj.get(p.v)){
                if(p.d + a.get(1) < dis[a.get(0)]){
                    dis[a.get(0)] = p.d + a.get(1);
                    pq.add(new Pair(a.get(0),dis[a.get(0)]));
                }
            }
        }
        return dis;
    }
}
