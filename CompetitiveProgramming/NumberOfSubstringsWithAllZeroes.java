public class NumberOfSubstringsWithAllZeroes {
    public class Solution {
        /**
         * @param str: the string
         * @return: the number of substrings
         */
        public int stringCount(String str) {
            // Write your code here.
            int zeros =0;
            int sum = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0')
                    zeros++;
                else if(zeros>0){
                    sum += (int)(zeros*(zeros+1))/2;
                    zeros=0;
                }
            }
            if(zeros>0)
                sum += (int)(zeros*(zeros+1))/2;
            return sum;
        }
    }
}
