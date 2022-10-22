import java.util.Arrays;

public class MovingTarget {
    public static void main(String[] args) {
        int [] nums = {5,10,8,7,2,4,6,4};
        MoveTarget(nums,4);
    }
    public static void MoveTarget(int[] nums, int target) {
        // write your code here
        int t =0;
        int right =nums.length-1;
        while(0<=right){
            if(nums[right] == target){
                t++;
            }else if(nums[right]!=target && t>0){
                nums[right+ t] = nums[right];
                nums[right] = target;
            }
            right--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
