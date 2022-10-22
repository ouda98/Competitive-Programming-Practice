public class PalindromicSubstrings {
    public static void main(String[] args) {
        int r = countPalindromicSubstrings("aba");
        System.out.println(r);
    }
    public static int countPalindromicSubstrings(String str) {
        // write your code here
        int result = str.length();
        int curSize = 2;
        while(curSize<=str.length()){
            int left = 0;
            int right = curSize-1;
            while(right<str.length()){
                if(palindromeCheck(str,left,right))
                    result++;
                right++;
                left++;
            }
            curSize++;
        }
        return result;
    }

    public static boolean palindromeCheck(String str, int left, int right){
        while(left<right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
