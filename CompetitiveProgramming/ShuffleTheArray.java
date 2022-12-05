public class ShuffleTheArray {
    public static void main(String[] args) {

    }
    public int[] shuffle(int[] nums, int n) {
        int [] res = new int[nums.length];
        int j = 0;
        for(int i=0;i<nums.length-1;i+=2){
            res[i]= nums[j];
            res[i+1] = nums[n+j];
            j++;
        }
        return res;
    }
}
