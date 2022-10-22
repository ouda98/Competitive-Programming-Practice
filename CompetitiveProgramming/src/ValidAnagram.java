import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {

    }
    public boolean anagram(String s, String t) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println(map.get('a'));
        System.out.print(map.get('b'));
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                return false;
            else{
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i)) == 0)
                    map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }
}
