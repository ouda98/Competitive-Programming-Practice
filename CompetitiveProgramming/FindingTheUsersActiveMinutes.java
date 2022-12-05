import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindingTheUsersActiveMinutes {
    public static void main(String[] args) {

    }
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] log: logs){
            if(!map.containsKey(log[0]))
                map.put(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        for(Map.Entry<Integer, HashSet<Integer>> set : map.entrySet()){
            result[set.getValue().size()-1]++;
        }
        return result;
    }
}
