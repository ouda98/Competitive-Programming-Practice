package LeetCodeCommonProblems;

public class MoveZeroes {
    public static void main(String[] args) {
    }
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeros++;
            else{
                if(zeros==0)
                    continue;
                nums[i-zeros] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
