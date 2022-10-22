import java.util.HashSet;

public class UniqueCharacters {
    public static void main(String[] args) {

    }
    public boolean isUnique(String str) {
        // write your code here
        char[] array = str.toCharArray();
        HashSet<Character> map = new HashSet<>();
        for(char c : array){
            if(map.contains(c)){
                return false;
            }
            map.add(c);
        }
        return true;
    }
}
