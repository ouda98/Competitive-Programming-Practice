import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {

    }
    static int dest;
    static List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dest = graph.length-1;
        result = new ArrayList<>();
        ArrayList<Integer> subResult = new ArrayList<>();
        subResult.add(0);
        dfs(0, graph, subResult);
        return result;
    }
    public void dfs(int source, int[][]grid, ArrayList<Integer> subResult){
        if(source == dest){
            result.add((ArrayList)subResult.clone());
            return;
        }
        for(int i=0;i<grid[source].length;i++){
            subResult.add(grid[source][i]);
            dfs(grid[source][i],grid,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
}
