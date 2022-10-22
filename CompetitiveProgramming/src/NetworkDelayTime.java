import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int [][] a = {{1,2,1}};
        int N = 2;
        int k = 2;
        System.out.println(networkDelayTime(a,N,k));

    }
    public static int networkDelayTime(int[][] times, int N, int K) {
        // Write your code here
        ArrayList<Pair>[] adj = new ArrayList[N+1];
        for(int i=0;i<adj.length;i++)
            adj[i] = new ArrayList<>();

        for(int i=0;i<times.length;i++){
            adj[times[i][0]].add(new Pair(times[i][1],times[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        int [] distance = new int[N+1];

        q.add(new Pair(K, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        while(!q.isEmpty()){
            Pair top = q.poll();
            if(distance[top.to]< top.weight)
                continue;
            for(int i=0;i<adj[top.to].size();i++){
                if(distance[adj[top.to].get(i).to] > top.weight + adj[top.to].get(i).weight){
                    distance[adj[top.to].get(i).to] = top.weight + adj[top.to].get(i).weight;
                    q.add(new Pair(adj[top.to].get(i).to,distance[adj[top.to].get(i).to]));
                }
            }
        }
        int max = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE)
                return -1;
            if(distance[i]>max)
                max = distance[i];
        }
        return max;
    }

    public static class Pair implements Comparable<Pair>{
        int to;
        int weight;
        public Pair(int to, int weight){
            this.to = to;
            this. weight = weight;
        }
        public int compareTo(Pair other){
            return this.weight - other.weight;
        }
    }
}
