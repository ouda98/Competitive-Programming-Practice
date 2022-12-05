import java.util.*;

public class SSSPUnweighted {
    public static void main(String[] args) {
        int nodes = 8;
        int source = 2;
        int destination = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nodes;i++)
            adj.add(new ArrayList<>());
        adj.get(1).add(0);
        adj.get(0).add(1);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(0).add(3);
        adj.get(3).add(0);

        adj.get(3).add(7);
        adj.get(7).add(3);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(7);
        adj.get(7).add(4);

        adj.get(7).add(6);
        adj.get(6).add(7);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(4).add(5);
        adj.get(5).add(4);
        int result = shortestPath(nodes,source, destination, adj);
        System.out.println("The shortest distance is : "+result);
    }
    public static int shortestPath(int n, int s, int d, List<List<Integer>> adj){
        if(s==d)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        int []parent = new int[n];
        int []distance = new int[n];
        Arrays.fill(distance,-1);
        q.add(s);
        distance[s] = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            for(int nums: adj.get(top)){
                if(distance[nums] == -1){
                    distance[nums] = distance[top]+1;
                    q.add(nums);
                    parent[nums] = top;
                }
            }
        }
        result = new ArrayList<>();
        findPath(s,d, parent);
        System.out.println(result.toString());

        return distance[d];
    }
    static ArrayList<Integer> result;
    public static void findPath(int s, int d, int[] parent){
        if(s == d){
            result.add(s);
            return;
        }
        findPath(s,parent[d],parent);
        result.add(d);
    }

}
