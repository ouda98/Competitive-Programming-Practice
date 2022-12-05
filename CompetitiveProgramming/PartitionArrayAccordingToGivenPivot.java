public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {

    }
    public int[] pivotArray(int[] nums, int pivot) {
        int left =0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int i=0;
        int j= nums.length-1;
        while(i<nums.length){
            if(nums[i]<pivot)
                res[left++] = nums[i];
            if(nums[j]>pivot)
                res[right--] = nums[j];
            i++;
            j--;
        }
        while(left<=right)
            res[left++] = pivot;
        return res;
    }
}
