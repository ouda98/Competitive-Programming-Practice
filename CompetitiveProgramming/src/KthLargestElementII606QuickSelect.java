public class KthLargestElementII606QuickSelect {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,8,9,10,7};
        int k = 1;
        int r=nums[quickSort(nums, 0 ,nums.length-1,k)];
    }
    public static int quickSort(int[] nums,int l, int r, int k){
        int index = partition(nums,l,r);

        if(index == nums.length-k)
            return index;

        if(index< nums.length-k)
            return quickSort(nums,index+1,r,k);
        else
            return quickSort(nums,l,index-1,k);

    }
    public static int partition(int[] nums,int l, int r){
        int pivot = nums[r];
        int locPos = l;
        int temp;
        for(int i=l;i<r;i++){

            if(nums[i]<pivot){
                temp = nums[i];
                nums[i] = nums[locPos];
                nums[locPos++] = temp;
            }
        }
        temp = nums[r];
        nums[r] = nums[locPos];
        nums[locPos] = temp;
        return locPos;
    }
}
