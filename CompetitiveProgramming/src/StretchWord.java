public class StretchWord {
    public static void main(String[] args) {
    }
    public class Solution {
        /**
         * @param S: the string
         * @return: The numbers of strings
         */
        public long stretchWord(String S) {
            // write your code here
            int counter =0;
            char at = '.';
            for(int i=0;i<S.length()-1;i++){
                if(S.charAt(i) == at)
                    continue;
                else if(S.charAt(i) == S.charAt(i+1)){
                    counter++;
                    at = S.charAt(i);
                }else
                    at = S.charAt(i);
            }
            return (long)Math.pow(2,counter);
        }
    }
}
