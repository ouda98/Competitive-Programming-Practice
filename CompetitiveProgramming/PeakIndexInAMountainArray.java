public class PeakIndexInAMountainArray {
    public static void main(String[] args) {

    }
    public int peakIndexInMountainArray(int[] a) {
        int left = 0;
        int right = a.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(a[mid -1]< a[mid] && a[mid+1]< a[mid])
                return mid;
            else if(a[mid-1] < a[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return 0;
    }
}
