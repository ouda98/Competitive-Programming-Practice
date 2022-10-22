package Algorithms;

public class QuickSelect {
    public static void main(String[] args) {
        int [] arr = {2,6,7,5,8,3};
        int k = 4;
        int r = partition(arr,0, arr.length-1,k-1);
        System.out.println(r);
    }

    private static int partition(int[] arr, int left, int right, int k) {
        int index = divide(arr, left, right, k);
        if(index == k)
            return arr[index];
        else if (index> k){
            return partition(arr,left,index-1,k);
        }else{
            return partition(arr,index+1,right,k);
        }
    }

    private static int divide(int[] arr, int left, int right, int k) {
        int pivotValue = arr[right];
        int pivLoc = left;
        for(int i=left;i<arr.length-1;i++){
            if(arr[i]<pivotValue){
                int temp = arr[i];
                arr[i] = arr[pivLoc];
                arr[pivLoc++] = temp;
            }
        }

        arr[right] = arr[pivLoc];
        arr[pivLoc] = pivotValue;
        return pivLoc;
    }
}
