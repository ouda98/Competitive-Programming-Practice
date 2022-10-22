public class ToLowerCase {
    public static void main(String[] args) {
    }
    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) >=65 && str.charAt(i)<=90) {
                sb.append((char)(32 + str.charAt(i)));
            }
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
