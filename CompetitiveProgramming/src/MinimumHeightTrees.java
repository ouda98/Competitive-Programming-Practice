import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> s =findMinHeightTrees(n,edges);
        System.out.println(Arrays.toString(s.toArray()));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Wirte your code here
        if(n == 1){
            return Arrays.asList(0);
        }
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<>();
        int [] indegree = new int[n];
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;

        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 1)
                q.add(i);
        }
        while(!q.isEmpty()){
            result = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                int top = q.poll();
                result.add(top);
                for(int j=0;j<adj[top].size();j++){
                    indegree[adj[top].get(j)]--;
                    if(indegree[adj[top].get(j)] == 1)
                        q.add(adj[top].get(j));
                }
            }
        }
        return result;
    }
    public static class Pair{
        int to;
        int distance;
        public Pair(int to, int distance){
            this.to = to;
            this.distance = distance;
        }
    }
}
