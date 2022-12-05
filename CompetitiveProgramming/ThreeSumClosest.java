import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {

    }
    public int threeSumClosest(int[] nums, int target) {
        int max = Integer.MAX_VALUE;
        int sum = -1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(max > Math.abs(target - (nums[i] + nums[left] + nums[right]))){
                    max = Math.abs(target - (nums[i] + nums[left] + nums[right]));
                    sum = nums[i] + nums[left] + nums[right];
                }if(nums[i] + nums[left]+ nums[right] < target)
                    left++;
                else
                    right--;
            }
        }
        return sum;
    }
}
