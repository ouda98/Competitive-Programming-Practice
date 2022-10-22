public class FindTheLargestDivisor {
    public int FindDivisor(int[] A, int k) {
        //
        int start = 1;
        int end = Integer.MAX_VALUE;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(can(A,mid,k)){
                result = mid;
                start = mid+1;
            }else
                end = mid -1;
        }
        return result;
    }
    public boolean can(int[] arr, int mid, int k){
        int sum = 0;
        for(int i=0;i<arr.length;i++)
            sum+= (int) Math.ceil(arr[i]/(mid*1.0));
        return sum>=k;
    }
}
