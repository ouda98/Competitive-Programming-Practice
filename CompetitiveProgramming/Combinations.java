import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result;
    static List<Integer> subResult;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        subResult = new ArrayList<>();
        dfs(n,1, k);
        return result;
    }
    public void dfs(int n, int pointer, int k){
        if(k==0){
            result.add(new ArrayList<Integer>(subResult));
            return;
        }
        if(pointer> n)
            return;
        subResult.add(pointer);
        dfs(n,pointer+1,k-1);
        subResult.remove(subResult.size()-1);
        dfs(n,pointer+1,k);
    }
}
