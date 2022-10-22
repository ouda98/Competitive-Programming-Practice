import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;

public class ModernLudoI {
    public static void main(String[] args) {
    }
    static int[] dice = {1,2,3,4,5,6};
    static PriorityQueue<Pair> q;
    static int result = -1;
    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        ArrayList<Integer> [] adj = new ArrayList[length+1];
        for(int i=0;i<adj.length;i++)
            adj[i] = new ArrayList<>();
        for(int i=0;i< connections.length;i++){
            adj[connections[i][0]].add(connections[i][1]);
        }
        result = -1;
        int [] distance = new int[length+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        q = new PriorityQueue<>();

        q.add(new Pair(1,0));
        distance[1] =0;
        while (!q.isEmpty()){
            Pair top = q.poll();
            if(distance[top.to] < top.weight)
                continue;
            int x;
            for(int i=0;i< dice.length;i++){
                x = top.to + dice[i];
                if(x<=length && distance[x]> top.weight + 1){
                    distance[x] = top.weight+1;
                    q.add(new Pair(x,distance[x]));
                    if(x == length)
                        return distance[x];
                    dfs(adj,distance,distance[x], x);
                    if(result!=-1)
                        return result;
                }
            }

        }
        return -1;
    }

    public static void dfs(ArrayList<Integer>[] adj, int [] distance, int weight, int x){
        for(int i=0;i<adj[x].size();i++){
            if(distance[adj[x].get(i)] > weight){
                distance[adj[x].get(i)] = weight;
                q.add(new Pair(adj[x].get(i),weight));
                if(adj[x].get(i) == distance.length-1){
                    result = weight;
                    return;
                }
                dfs(adj,distance,weight,adj[x].get(i));

            }
        }
    }

    public static class Pair implements Comparable<Pair> {
        int to;
        int weight;
        public Pair(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Pair other){
            return this.weight - other.weight;
        }
    }




}
