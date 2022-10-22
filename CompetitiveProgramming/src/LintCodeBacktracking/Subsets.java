package LintCodeBacktracking;

import java.util.*;

public class Subsets {
    static List<List<Integer>> x;

    public static void main(String[] args) {
        x = new LinkedList<>();
        int[] nums = {4, 1, 0};
        Arrays.sort(nums);
        solve(nums, 0, new LinkedList<Integer>());
        System.out.println(x);
    }

    public static void solve(int[] nums, int idx, LinkedList<Integer> list) {
        if (idx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (Integer i : list)
                l.add(i);
            x.add(l);
            return;
        }
        solve(nums, idx + 1, list);
        list.add(nums[idx]);
        solve(nums, idx + 1, list);
        list.removeLast();


    }
}
