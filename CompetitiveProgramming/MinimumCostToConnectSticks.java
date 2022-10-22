import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(8);arr.add(3);arr.add(5);
        System.out.println(MinimumCost(arr));
    }
    public static int MinimumCost(List<Integer> sticks) {
        // write your code here
        if(sticks.size() == 0)
            return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0;i<sticks.size();i++){
            q.add(sticks.get(i));
        }
        int result =0;
        while(q.size()>1){
            int merge = q.poll() + q.poll();
            result += merge;
            q.add(merge);

        }
        return result;
    }
}
