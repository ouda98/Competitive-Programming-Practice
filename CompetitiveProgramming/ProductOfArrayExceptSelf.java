public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeros = 0;
        for(int n : nums){
            zeros+= n==0?1:0;
            product*= n!=0?n:1;
        }
        for(int i =0;i<nums.length;i++){
            if(zeros>1)
                nums[i] = 0;
            else if(zeros ==1 && nums[i] !=0)
                nums[i] = 0;
            else if(zeros ==1 && nums[i] ==0)
                nums[i] = product;
            else if(zeros == 0){
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}
