import java.util.Arrays;

public class SortColors148QuickSelect {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2};
        int index = quickSelect(nums,0,nums.length-1,2);
        quickSelect(nums,0,index,1);
        System.out.println(Arrays.toString(nums));
    }
    public static int quickSelect(int [] nums, int l, int r, int target){
        int index = partition(nums,l,r);

        if(nums[index]==target)
            return index;
        if(nums[index]<target)
            return quickSelect(nums,index+1,r,target);
        else
            return quickSelect(nums,l,index-1,target);
    }

    public static int partition(int [] nums, int l, int r){
        int pivot = nums[r];
        int loc = l;
        int temp;
        for(int i=l;i<r;i++){
            if(nums[i]<pivot){
                temp = nums[i];
                nums[i] = nums[loc];
                nums[loc++] = temp;
            }
        }
        temp = nums[r];
        nums[r] = nums[loc];
        nums[loc] = temp;
        return loc;
    }
}
