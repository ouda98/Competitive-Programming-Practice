public class MinimumCutsToDivideACircle {
    public static void main(String[] args) {

    }
    public int numberOfCuts(int n) {
        return n%2==0?n/2:n==1?0:n;
    }
}
