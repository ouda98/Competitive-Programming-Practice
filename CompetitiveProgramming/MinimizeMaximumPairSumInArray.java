import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {

    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i=0;i<nums.length/2;i++){
            if(nums[i]+ nums[nums.length-1-i]>max)
                max = nums[i]+ nums[nums.length-1-i];
        }
        return max;
    }
}
