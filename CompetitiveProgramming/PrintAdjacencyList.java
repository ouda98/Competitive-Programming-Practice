import java.util.ArrayList;

public class PrintAdjacencyList {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subResult = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            subResult.add(i);
            for(int num : adj.get(i))
                subResult.add(num);
            result.add(subResult);
            subResult = new ArrayList<>();
        }
        return result;
    }
}
