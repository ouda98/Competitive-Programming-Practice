import java.util.List;

public class MinimumSubarray {
    public class Solution {
        /*
         * @param nums: a list of integers
         * @return: A integer indicate the sum of minimum subarray
         */
        public int minSubArray(List<Integer> nums) {
            // write your code here
            int min = (int) 1e9;
            int top = (int) 1e9;
            for(int i=0;i<nums.size();i++){
                if(min + nums.get(i)<nums.get(i))
                    min += nums.get(i);
                else
                    min = nums.get(i);
                if(min<top)
                    top = min;
            }
            return top;
        }
    }
}
