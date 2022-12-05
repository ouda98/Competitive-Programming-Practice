import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {

    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer,ArrayList<Pair>> adj = new HashMap<>();
        for(int i=0;i<n;i++)
            adj.put(i, new ArrayList<>());
        for(int[]edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        int[] distance = new int[adj.size()];
        Queue<Pair> q = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        int res = -1;
        int count;
        Pair top;
        for(Map.Entry<Integer, ArrayList<Pair>> set : adj.entrySet()){
            q.add(new Pair(set.getKey(),0));
            Arrays.fill(distance, -1);
            distance[set.getKey()] = 0;
            count = 0;
            while(!q.isEmpty()){
                top = q.poll();
                if(top.cost>distanceThreshold)
                    continue;
                for(Pair p : adj.get(top.to)){
                    if(top.cost + p.cost<=distanceThreshold && (distance[p.to] == -1 || (top.cost + p.cost<distance[p.to]))){
                        if(distance[p.to] == -1) count++;
                        distance[p.to]= top.cost + p.cost;
                        q.add(new Pair(p.to,top.cost + p.cost));
                    }
                }
            }
            if(max>=count){
                max = count;
                res = Math.max(res,set.getKey());
            }

        }
        return res;
    }
    public class Pair{
        int to;
        int cost;
        public Pair(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
