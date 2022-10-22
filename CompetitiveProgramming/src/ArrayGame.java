public class ArrayGame {
    public static void main(String[] args) {

    }
    public class Solution {

        public long arrayGame(int[] arr) {
            // write your code here
            if(arr == null && arr.length==0)
                return 0;
            int min = arr[0];
            for(int i=0;i<arr.length;i++)
                if(min>arr[i])
                    min = arr[i];

            long result = 0;
            for(int i=0;i<arr.length;i++){
                result+= (arr[i] - min);
            }

            return result;
        }
    }
}
