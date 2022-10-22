import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public static void main(String[] args) {

    }
    static List<List<Integer>> se;
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        se = new ArrayList<List<Integer>>();
        find(n,n,2,new ArrayList<>());
        return se;
    }
    public void find(int n, int remainder, int i, List<Integer> s){
        if (remainder == 1){
            se.add(new ArrayList<>(s));
            return;
        }
        for(;i<n;i++){
            if(remainder % i ==0){
                s.add(i);
                find(n, remainder/i, i,s);
                s.remove(s.size()-1);
            }
        }
    }
}
