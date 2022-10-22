public class SumOfTwoStrings {
    public static void main(String[] args) {

    }
    public String sumOfTwoStrings(String a, String b) {
        // write your code here
        int la = a.length()-1;
        int lb = b.length()-1;
        String res = "";
        int va = 0;
        int vb = 0;
        while(la>=0 || lb>=0){
            if(la>=0){
                va = Character.getNumericValue(a.charAt(la--));
            }if(lb>=0){
                vb = Character.getNumericValue(b.charAt(lb--));
            }
            res = (va + vb) + res;
            va = 0;
            vb = 0;
        }
        return res;
    }
}
