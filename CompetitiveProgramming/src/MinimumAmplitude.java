import java.util.Arrays;

public class MinimumAmplitude {
    public class Solution {
        /**
         * @param A: a list of integer
         * @return: Return the smallest amplitude
         */
        public int MinimumAmplitude(int[] A) {
            // write your code here
            if(A.length<=4)
                return 0;
            Arrays.sort(A);
            int min = (int)1e9;
            for(int i=0;i<4;i++){
                min = Math.min(min, A[A.length-4+i] - A[i]);
            }
            return min;

        }
    }
}
