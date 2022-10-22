public class RotateStringII {
    public static void main(String[] args) {
        String str = "abcdefg";
        int left = 0;
        int right = 0;
        String r = RotateString2(str, left, right);
        System.out.println(r);

    }

    public static String RotateString2(String str, int left, int right) {
        // write your code here
        int offset = 0;
        if(left> right){
            offset = (left - right) % str.length();
            return str.substring(offset) + str.substring(0,offset);
        }
        if(left < right){
            offset = (right - left) % str.length();
            return str.substring(str.length()-offset) + str.substring(0,str.length()- offset);
        }
        return str;
    }
}
