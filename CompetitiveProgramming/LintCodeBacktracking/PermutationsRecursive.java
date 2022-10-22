package LintCodeBacktracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsRecursive {
    public class Solution {
        /**
         * @param nums: A list of integers.
         * @return: A list of permutations.
         */
        static List<List<Integer>> x;

        public List<List<Integer>> permute(int[] nums) {
            // write your code here
            x = new LinkedList<>();
            solve(nums, 0);
            return x;
        }

        public static void solve(int[] nums, int idx) {
            if (idx == nums.length) {
                List<Integer> intList = new ArrayList<Integer>(nums.length);
                for (int i : nums) {
                    intList.add(i);
                }
                x.add(intList);
                return;
            }
            for (int i = idx; i < nums.length; i++) {
                swap(i, idx, nums);
                solve(nums, idx + 1);
                swap(i, idx, nums);
            }

        }

        private static void swap(int i, int idx, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }

    //String permutation recursive

//    private static void permutation(String prefix, String str) {
//        int n = str.length();
//        if (n == 0) System.out.println(prefix);
//        else {
//            for (int i = 0; i < n; i++)
//                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
//        }
//    }
}