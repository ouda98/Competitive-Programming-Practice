import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result;
    static List<Integer> subResult;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target, 0);
        return result;
    }
    public void dfs(int[] candidates, int target, int pointer){
        if(target == 0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0 || pointer>= candidates.length){
            return;
        }
        subResult.add(candidates[pointer]);
        dfs(candidates,target - candidates[pointer],pointer+1);
        subResult.remove(subResult.size()-1);
        while(pointer+1 < candidates.length && candidates[pointer] == candidates[pointer+1])
            pointer++;
        dfs(candidates,target,pointer+1);
    }
}
