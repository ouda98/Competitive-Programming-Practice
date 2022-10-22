package LintCodeBacktracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationsLeetCode {
    static List<List<Integer>> s;
    public static void main(String[] args) {
        s = new LinkedList<>();
        int n =4;
        int k = 2;
        solve(n,k,1,0, new LinkedList<>());
        System.out.println(s);
    }

    private static void solve(int n, int k, int idx,int sum, List<Integer> r) {
        if(sum==k){
            List<Integer> e = new LinkedList<>(r);
            s.add(e);
            return;
        }
        for(int i=idx;i<=n;i++){
            r.add(i);
            solve(n,k,i+1,sum+1,r);
            r.remove(r.size()-1);
        }
    }
}
