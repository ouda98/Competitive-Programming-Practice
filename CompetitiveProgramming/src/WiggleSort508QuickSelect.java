import java.util.Arrays;

public class WiggleSort508QuickSelect {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};

        int index = quickSort(nums,0,nums.length-1,(nums.length+1)/2);
        int rev = nums.length-2;
        int temp;
        for(int i=1;i<nums.length/2;i+=2){
            if(rev<0)
                break;
            temp = nums[i];
            nums[i] = nums[rev];
            nums[rev]=temp;
            rev-=2;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int quickSort(int[] nums,int l, int r, int k){
        int index = partition(nums,l,r);

        if(index == k-1)
            return index;

        if(index< k-1)
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
