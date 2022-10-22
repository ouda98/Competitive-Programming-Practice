package LeetCodeCommonProblems;

public class ValidPalindrome {
    public static void main(String[] args) {
        String r = "A man, a plan, a canal: Panama";
        isPalindrome(r);
    }
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]+", "").trim().toLowerCase();
        int start =0;
        int end = s.length()-1;
        while(start< end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
