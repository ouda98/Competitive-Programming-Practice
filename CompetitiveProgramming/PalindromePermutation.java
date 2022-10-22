import java.util.HashSet;

public class PalindromePermutation {
    public static void main(String[] args) {

    }
    public boolean canPermutePalindrome(String s) {
        // write your code here
        if(s == null || s.length() ==0)
            return true;
        HashSet<Character> map = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(map.contains(s.charAt(i)))
                map.remove(s.charAt(i));
            else
                map.add(s.charAt(i));
        }
        return map.size()<=1?true:false;
    }
}
