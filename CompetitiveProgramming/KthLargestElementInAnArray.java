public class KthLargestElementInAnArray {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        return find(0,nums.length-1,nums,nums.length - k);
    }
    public int find(int low, int high, int[]nums, int k){
        int partition = partition(low, high,nums);
        if(partition == k)
            return nums[partition];
        if(partition<k)
            return find(partition+1, high, nums,k);
        else
            return find(low, partition-1, nums,k);
    }
    public int partition(int low, int high, int[]nums){
        int pivot = nums[high];
        int pivotLoc = low;
        int temp = 0;
        for(int i= low;i<high;i++){
            if(nums[i] < pivot){
                temp = nums[pivotLoc];
                nums[pivotLoc] = nums[i];
                nums[i] = temp;
                pivotLoc++;
            }
        }
        temp = nums[pivotLoc];
        nums[pivotLoc] = nums[high];
        nums[high] = temp;
        return pivotLoc;
    }
}
