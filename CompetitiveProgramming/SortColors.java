public class SortColors {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int zero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
        }
        int one = zero;
        for(int i=zero;i<nums.length;i++){
            if(nums[i] == 1){
                int temp = nums[one];
                nums[one] = nums[i];
                nums[i] = temp;
                one++;
            }
        }
    }
}
