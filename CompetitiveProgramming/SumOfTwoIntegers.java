public class SumOfTwoIntegers {
    public static void main(String[] args) {

    }
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = a&b;
            a^=b;
            b = carry<<1;
        }
        return a;
    }
}
