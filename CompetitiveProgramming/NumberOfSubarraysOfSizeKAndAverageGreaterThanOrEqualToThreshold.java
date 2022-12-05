public class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {

    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i=0;i<k;i++)
            sum+= arr[i];
        int count = 0;
        for(int i=0;i<=arr.length-k;i++){
            count += (sum/k>=threshold)?1:0;
            if(i+k<arr.length){
                sum-= arr[i];
                sum+=arr[i+k];
            }
        }
        return count;
    }
}
