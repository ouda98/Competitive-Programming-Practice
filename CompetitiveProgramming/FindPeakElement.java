public class FindPeakElement {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] arr) {
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int before = (mid-1>=0)?arr[mid-1]:Integer.MIN_VALUE;
            int after = (mid+1<arr.length)?arr[mid+1]:Integer.MIN_VALUE;
            if(arr[mid]>after && arr[mid]>before)
                return mid;
            else if(arr[mid]<after)
                start = mid+1;
            else
                end = mid-1;
        }
        return 0;
    }
}
