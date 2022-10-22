package LintCodeFacebookQuestions;

public class ProductOfArrayExceptSelf {
    public class Solution {
        /**
         * @param nums: an array of integers
         * @return: the product of all the elements of nums except nums[i].
         */
        public int[] productExceptSelf(int[] nums) {
            // write your code here
            int sum = 1;
            int zeros =0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0)
                    zeros++;
                else{
                    sum*=nums[i];
                }
            }
            int [] result = new int [nums.length];
            for(int i =0;i<nums.length;i++){
                if(zeros>1 || zeros==1 && nums[i]!=0)
                    result[i] = 0;
                else if(zeros==1 && nums[i]==0)
                    result[i] = sum;
                else
                    result[i] = sum/nums[i];

            }


            // System.out.println(Arrays.toString(s));
            return result;
        }
    }
}
