import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(int n : nums){
            if(map.containsKey(n) && (i - map.get(n))<=k)
                return true;
            map.put(n,i++);
        }
        return  false;
    }
}
