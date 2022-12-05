public class FindPivotIndex {
    public static void main(String[] args) {

    }
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++)
            total+=nums[i];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum*2 == total- nums[i])
                return i;
            sum+=nums[i];
        }
        return -1;
    }
}
