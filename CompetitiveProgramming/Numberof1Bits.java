public class Numberof1Bits {
    public static void main(String[] args) {

    }
    //Solution 1
    public int hammingWeight1(int n) {
        // String s = Integer.toBinaryString(n);
        // int sum =0;
        // for(int i=0;i<s.length();i++)
        //     if(s.charAt(i) == '1')
        //         sum++;
        return Integer.bitCount(n);
    }
    //Solution 1
    public int hammingWeight(int n) {
         String s = Integer.toBinaryString(n);
         int sum =0;
         for(int i=0;i<s.length();i++)
             if(s.charAt(i) == '1')
                 sum++;
        return sum;
    }

}
