import java.util.HashMap;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {

    }
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = 0;
        int val = -1;
        for(int i=0;i<edges.length;i++){
            map.put(edges[i][0], map.getOrDefault(edges[i][0],0)+1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1],0)+1);
            if(map.get(edges[i][0])>map.get(edges[i][1]) && min<map.get(edges[i][0])){
                min = map.get(edges[i][0]);
                val = edges[i][0];
            }else if(map.get(edges[i][0])<=map.get(edges[i][1]) && min<map.get(edges[i][1])){
                min = map.get(edges[i][1]);
                val = edges[i][1];
            }
        }
        return val;
    }
}
