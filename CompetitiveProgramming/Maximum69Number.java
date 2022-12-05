public class Maximum69Number {
    public static void main(String[] args) {

    }
    public int maximum69Number (int num) {
        String s = num+"";
        return Integer.parseInt(s.replaceFirst("6","9"));
    }
}
