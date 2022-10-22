import java.util.Arrays;

public class SimpleQueries {
    public class Solution {
        /**
         * @param nums:
         * @param sub:
         * @return: return a Integer array
         */
        public int[] SimpleQueries (int[] nums, int[] sub) {
            // write your code here
            Arrays.sort(nums);
            for(int i=0;i<sub.length;i++){
                sub[i] = binarySearch(nums, 0,nums.length-1, sub[i]) +1;
            }
            return sub;

        }
        public static int binarySearch(int[] nums, int left, int right, int target){
            int result = -1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if (nums[mid]<=target){
                    result = mid;
                    left = mid+1;
                }else
                    right = mid-1;
            }
            return result;
        }
    }
}
