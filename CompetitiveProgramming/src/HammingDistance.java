public class HammingDistance {
    public static void main(String[] args) {

    }
    public class Solution {

        public int hammingDistance(int x, int y) {
            // write your code here
            int result = x^y;
            String s =Integer.toBinaryString(result);
            int sum =0;
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)== '1')
                    sum++;
            return sum;
        }
    }
}
