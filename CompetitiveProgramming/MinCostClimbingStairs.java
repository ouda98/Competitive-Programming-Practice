import java.util.HashMap;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }
    static HashMap<Integer, Integer> map;
    public int minCostClimbingStairs(int[] cost) {
        map = new HashMap<>();
        return Math.min(helper(cost,0),helper(cost,1));
    }
    public int helper(int[] cost, int pointer){
        if(pointer >= cost.length)
            return 0;
        if(map.containsKey(pointer))
            return map.get(pointer);
        int a = cost[pointer] + helper(cost, pointer+1);
        int b = cost[pointer] + helper(cost, pointer+2);
        map.put(pointer, Math.min(a,b));
        return Math.min(a,b);
    }
}
