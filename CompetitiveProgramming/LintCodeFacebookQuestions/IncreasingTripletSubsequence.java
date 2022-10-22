package LintCodeFacebookQuestions;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        increasingTriplet(nums);
    }
    public static boolean increasingTriplet(int[] nums) {
        // write your code
        if(nums.length<3)
            return false;
        int first = nums[0];
        int second = nums[1];
        for(int i=2;i<nums.length;i++){
            if(nums[i]>first && nums[i]>second)
                return true;
            else{
                if(nums[i]<Math.max(first,second)){
                    if(first>second)
                        first = nums[i];
                    else
                        second = nums[i];
                }
            }
        }
        return false;
    }
}
