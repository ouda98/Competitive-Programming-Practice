public class Median {
    public static void main(String[] args) {
        int [] arr = {2,3,1,1,1,1,1,4,5,9};
        System.out.println(median(arr));
    }
    public static int median(int[] nums) {
        // write your code here
        int index = nums.length/2;
        if(nums.length %2 ==0)
            index -=1;
        return quickSelect(nums, 0, nums.length-1, index);
    }
    public static int quickSelect(int [] nums, int left ,int right, int target){
        int index = partition(nums,left,right);
        if(index == target)
            return nums[index];
        if(index<target)
            return quickSelect(nums, index+1, right, target);
        else
            return quickSelect(nums, left, index-1, target);
    }
    public static int partition(int [] nums, int left, int right){
        int value = nums[right];
        int pivLoc = left;
        for(int i=left;i<=right;i++){
            if(nums[i]<value){
                int temp = nums[i];
                nums[i] = nums[pivLoc];
                nums[pivLoc++] = temp;
            }
        }
        int temp = nums[right];
        nums[right] = nums[pivLoc];
        nums[pivLoc] = temp;
        return pivLoc;
    }
}
