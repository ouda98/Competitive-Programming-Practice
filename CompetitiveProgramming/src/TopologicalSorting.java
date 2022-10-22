import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    class DirectedGraphNode {
     int label;
    List<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<>();
     }
 }
    public static void main(String[] args) {
    }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<graph.size();i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, graph,s,visited);
            }
        }
        ArrayList<DirectedGraphNode> n = new ArrayList<>();
        while(!s.isEmpty()){
            n.add(new DirectedGraphNode(s.pop()));
        }
        return n;
    }
    public static void dfs(int x, ArrayList<DirectedGraphNode> graph, Stack<Integer> s, boolean[] visited){
        for(DirectedGraphNode i: graph.get(x).neighbors){
            if(!visited[i.label]){
                visited[i.label] = true;
                dfs(i.label,graph,s,visited);
            }
        }
        s.push(x);
    }
}
