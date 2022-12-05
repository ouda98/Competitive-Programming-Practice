import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {

    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            if(!map.containsKey(groupSizes[i]))
                map.put(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size() == groupSizes[i]){
                res.add(new ArrayList<>(map.get(groupSizes[i])));
                map.put(groupSizes[i],new ArrayList<>());
            }
        }
        return res;
    }


}
