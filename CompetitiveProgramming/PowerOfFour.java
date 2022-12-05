public class PowerOfFour {
    public static void main(String[] args) {

    }
    public boolean isPowerOfFour(int n) {
        return Math.log10(n)/Math.log10(4) % 1 == 0;
    }
}
