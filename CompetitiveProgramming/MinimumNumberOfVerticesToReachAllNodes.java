import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {

    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for(List<Integer> edge : edges){
            indegree[edge.get(1)]++;
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0)
                result.add(i);
        }
        return result;
    }
}
