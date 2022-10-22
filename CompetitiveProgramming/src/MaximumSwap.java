public class MaximumSwap {

    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param num: a non-negative intege
         * @return: the maximum valued number
         */
        public int maximumSwap(int num) {
            // Write your code here
            String s = ""+num;
            char[] ch = s.toCharArray();
            int pos = -1;
            for(int i=0;i<ch.length;i++){
                char max = '0';

                for(int j=ch.length-1;j>i;j--){
                    if(ch[i]<ch[j] && ch[j]>max){
                        max = ch[j];
                        pos = j;
                    }
                }
                if(max>'0'){
                    char temp = ch[i];
                    ch[i] = max;
                    ch[pos] = temp;
                    break;
                }

            }
            s = String.valueOf(ch);
            return Integer.parseInt(s);
        }
    }
}
