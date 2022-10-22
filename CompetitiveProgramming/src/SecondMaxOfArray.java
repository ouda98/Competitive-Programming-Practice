public class SecondMaxOfArray {
    public static void main(String[] args) {
    }
    public class Solution {
        /**
         * @param nums: An integer array
         * @return: The second max number in the array.
         */
        public int secondMax(int[] nums) {
            // write your code here
            int k = nums.length - 2;
            return quickSelect(nums, 0, nums.length-1, k);
        }
        public static int quickSelect(int [] nums, int left, int right, int k){
            int partition = partiton(nums, left, right, k);
            if(partition== k)
                return nums[partition];
            if(partition>k)
                return quickSelect(nums, left, partition-1, k);
            else
                return quickSelect(nums, partition+1, right, k);
        }
        public static int partiton(int [] nums, int left, int right, int k){
            int pivotValue = nums[right];
            int pivLoc = left;
            for(int i=left;i<right;i++){
                if(nums[i]< pivotValue){
                    int temp = nums[i];
                    nums[i] = nums[pivLoc];
                    nums[pivLoc++] = temp;
                }
            }
            nums[right] = nums[pivLoc];
            nums[pivLoc] = pivotValue;
            return pivLoc;
        }
    }
}
