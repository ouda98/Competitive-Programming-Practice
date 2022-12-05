import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            set = new HashSet<>();
            count = 0;
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    count++;
                }else{
                    break;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
