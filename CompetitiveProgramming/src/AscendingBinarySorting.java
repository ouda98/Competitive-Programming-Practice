import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AscendingBinarySorting {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param nums: the original integer array
         * @return: the integer array after sorting
         */
        public int[] AscendingBinarySorting(int[] nums) {
            // Write your code here
            ArrayList<Integer> s = new ArrayList<>();

            for(int i=0;i<nums.length;i++)
                s.add(nums[i]);
            Collections.sort(s,new Sort());
            for(int i=0;i<s.size();i++)
                nums[i] = s.get(i);
            return nums;
        }

        public static class Sort implements Comparator<Integer> {
            public int compare(Integer a, Integer b){
                if(Integer.bitCount(a) == Integer.bitCount(b))
                    return a - b;
                return Integer.bitCount(a) - Integer.bitCount(b);
            }
        }
    }
}
