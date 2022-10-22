package FacebookPreInterview;


import java.util.Arrays;

public class SlowSums {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        getTotalTime(arr);
    }
    static int getTotalTime(int[] arr) {
        // Write your code here
        if(arr.length==0 || arr.length==1)
            return 0;
        Arrays.sort(arr);

        int sum = arr[arr.length-1];
        int penlty = 0;
        if(arr.length>1){
            for(int i=arr.length-2;i>=0;i--){
                sum+=arr[i];
                penlty +=sum;
            }
        }
        return penlty;
    }
}
