package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, adj,s,visited);
            }
        }
        int[] arr = new int[s.size()];
        int i = 0;
        while(!s.isEmpty()){
            arr[i++] = s.pop();
        }
        return arr;

    }
    public static void dfs(int x, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean[] visited){
        for(Integer i: adj.get(x)){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,adj,s,visited);
            }
        }
        s.push(x);
    }
}
