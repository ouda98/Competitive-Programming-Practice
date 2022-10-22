import java.util.HashMap;

public class CompareStrings {
    public static void main(String[] args) {

    }
    public boolean compareStrings(String a, String b) {
        // write your code here
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<a.length();i++){
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0;i<b.length();i++){
            if(!map.containsKey(b.charAt(i)))
                return false;
            else {
                map.put(b.charAt(i),map.get(b.charAt(i))-1);
                if(map.get(b.charAt(i)) == 0)
                    map.remove(b.charAt(i));
            }
        }
        return true;
    }


}
