public class PowerOfThree {
    public static void main(String[] args) {

    }
    //Solution 1
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
    //Solution 2
    public boolean isPowerOfThree1(int n) {
        if(n==0)
            return false;
        while(n%3 == 0){
            n = n/3;
        }
        return n == 1;
    }
}
