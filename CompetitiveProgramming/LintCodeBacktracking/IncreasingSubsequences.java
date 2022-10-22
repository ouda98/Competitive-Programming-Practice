package LintCodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IncreasingSubsequences {
    public static void main(String[] args) {
    }
    public class Solution {
        /**
         * @param nums: an integer array
         * @return: all the different possible increasing subsequences of the given array
         */
        static List<List<Integer>> result;
        static HashSet<String> set;
        public List<List<Integer>> findSubsequences(int[] nums) {
            set = new HashSet<>();
            result = new ArrayList<>();
            solve(nums, new ArrayList<Integer>(),0, Integer.MIN_VALUE);
            return result;
        }
        public static void solve(int [] nums, List<Integer> s, int idx, int max){
            if(idx == nums.length && s.size()>=2 && !set.contains(s.toString())){
                set.add(s.toString());
                List<Integer> r = new ArrayList<>();
                for(Integer num : s)
                    r.add(num);
                result.add(r);
                return;
            }
            if(idx == nums.length)
                return;

            if(max<= nums[idx]){
                s.add(nums[idx]);
                solve(nums, s, idx+1, nums[idx]);
                s.remove(s.size()-1);
            }
            solve(nums, s, idx+1, max);

        }
    }
}

