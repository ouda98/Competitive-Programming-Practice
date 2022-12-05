public class ReverseBits {
    public static void main(String[] args) {

    }
    public int reverseBits(int n) {
        int results = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>= 1;
            results <<= 1;
            results |= end;
        }
        return results;
    }
}
