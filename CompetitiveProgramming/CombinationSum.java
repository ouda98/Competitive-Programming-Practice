import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result;
    static List<Integer> subResult;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        dfs(candidates,target, 0);
        return result;
    }
    public void dfs(int[] candidates, int target, int pointer){
        if(target<0 || pointer>= candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        subResult.add(candidates[pointer]);
        dfs(candidates,target- candidates[pointer],pointer);
        subResult.remove(subResult.size()-1);
        dfs(candidates,target,pointer+1);
    }
}
