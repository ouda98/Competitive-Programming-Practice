public class MaximumSubarray {
    public class Solution {
        /**
         * @param nums: A list of integers
         * @return: A integer indicate the sum of max subarray
         */
        public int maxSubArray(int[] nums) {
            // write your code here
            int maxSub = (int)-1e9;
            int top = (int)-1e9;
            for(int i=0;i<nums.length;i++){
                if(maxSub + nums[i]>nums[i]){
                    maxSub += nums[i];
                }else{
                    maxSub = nums[i];
                }
                if(maxSub>top)
                    top = maxSub;

            }
            return top;
        }
    }

}
