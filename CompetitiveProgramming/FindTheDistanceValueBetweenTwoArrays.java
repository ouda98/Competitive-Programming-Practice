import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {

    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int n: arr1){
            count+= bin(n,arr2,d);
        }
        return count;
    }
    public int bin(int n, int[] arr2, int d){
        int left = 0;
        int right = arr2.length-1;

        while(left<=right){
            int mid = (right-left)/2 + left;
            if(Math.abs(n-arr2[mid])<=d)
                return 0;
            else if(n-arr2[mid]>d)
                left = mid+1;
            else
                right = mid-1;
        }
        return 1;
    }
}
