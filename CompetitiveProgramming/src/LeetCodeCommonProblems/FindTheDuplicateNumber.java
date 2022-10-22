package LeetCodeCommonProblems;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int d = -1;
        for(int i=0;i<nums.length;i++){
            int cur = Math.abs(nums[i]);
            if(nums[cur]<0){
                d = cur;
                break;
            }
            nums[cur]*=-1;
        }
        for(int i=0;i<nums.length;i++)
            nums[i] = Math.abs(nums[i]);
        return d;
    }
}
