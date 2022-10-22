package LintCodeBacktracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIIILeetCode {
    static List<List<Integer>> s;
    static int [] nums;
    public static void main(String[] args) {
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        s = new LinkedList<>();
        int k = 3;
        int n = 9;
        solve(n,k,0,0,0,new LinkedList<>());
        System.out.println(s);
    }

    private static void solve(int n, int k, int idx,int sum,int count, LinkedList<Integer> r) {
        if(count == k && sum==n){
                List<Integer> e = new LinkedList<>();
                e.addAll(r);
                s.add(e);
            return;
        }
        if(count == k || idx== nums.length)
            return;
        r.add(nums[idx]);
        solve(n,k,idx+1,sum+nums[idx],count+1,r);
        r.removeLast();
        solve(n,k,idx+1,sum,count,r);
    }

}
