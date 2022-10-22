public class MinimumMoves {
    public static void main(String[] args) {
        String value  = "baabab";
        System.out.println(MinimumMoves(value));
    }
    public static int MinimumMoves(String S) {
        // write your code here
        int counter =0;
        for(int i=0;i<S.length()-2;i++){
            if(S.charAt(i) == S.charAt(i+1) && S.charAt(i+1) == S.charAt(i+2)){
                counter++;
                i+=2;
            }

        }
        return counter;
    }
}
