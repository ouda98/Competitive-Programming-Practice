import java.util.List;

public class RecoverRotatedSortedArray {
    public class Solution {
        /**
         * @param nums: An integer array
         * @return: nothing
         */
        public void recoverRotatedSortedArray(List<Integer> nums) {
            // write your code here
            while(true){
                if(nums.get(0)>=nums.get(nums.size()-1)){
                    nums.add(nums.get(0));
                    nums.remove(0);
                }else {
                    break;
                }
            }
        }
    }
}
