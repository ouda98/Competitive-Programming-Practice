public class WiggleSort {
    public class Solution {
        /*
         * @param nums: A list of integers
         * @return: nothing
         */
        public void wiggleSort(int[] nums) {
            // write your code here
            for(int i=0;i<nums.length-1;i++){
                if(i%2==0){
                    if(nums[i]>nums[i+1]){
                        swap(nums,i,i+1);
                    }
                }else{
                    if(nums[i]<nums[i+1]){
                        swap(nums,i,i+1);
                    }

                }

            }
        }
        public static void swap(int [] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
