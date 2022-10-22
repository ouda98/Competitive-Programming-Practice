public class SortIntegersII {
    public static void main(String[] args) {

    }
    public class Solution {

        public void sortIntegers2(int[] A) {
            // write your code here
            quickSort(A, 0, A.length-1);
        }

        public static void quickSort(int[]A, int start, int end){
            if(start<end){
                int index = partition(A, start,end,A[(end+start)/2]);
                quickSort(A,start, index-1);
                quickSort(A,index, end);
            }
        }

        public static int partition(int[] A, int left, int right, int target){
            while(left<=right){
                while(A[left]<target)
                    left++;
                while(A[right]>target)
                    right--;
                if(left<=right){
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                    left++;
                    right--;
                }
            }
            return left;
        }
    }
}
