import java.util.ArrayList;

public class BuddyStrings {
    public static void main(String[] args) {

    }
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length())
            return false;
        int max = 0;
        int [] chars = new int[26];
        ArrayList<Character> c = new ArrayList<>();
        for(int i=0;i<a.length();i++){
            max = Math.max(max,++chars[a.charAt(i)-'a']);
            if(a.charAt(i) != b.charAt(i)){
                c.add(a.charAt(i));
                c.add(b.charAt(i));
            }
        }
        if((max>=2 && a.equals(b)) || (c.size() == 4 && c.get(0) == c.get(3) && c.get(1) == c.get(2)))
            return true;
        return false;
    }
}
