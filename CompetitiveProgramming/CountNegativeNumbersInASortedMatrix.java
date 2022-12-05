public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {

    }
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] n: grid){
            count+= bin(n);
        }
        return count;
    }
    public int bin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = (right - left)/2 + left;
            if(nums[mid]<0){
                index = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(index == -1)
            return 0;
        return nums.length - index;
    }
}
