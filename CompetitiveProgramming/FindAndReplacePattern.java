import java.util.*;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] s = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> r =findAndReplacePattern(s, pattern);
        System.out.println(Arrays.toString(r.toArray()));
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        // Write your code here.
        List<String> result = new ArrayList<>();
        boolean match;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            map.clear();
            set.clear();
            String word = words[i];
            if(word.length() != pattern.length())
                continue;
            match = true;
            for(int j=0;j<pattern.length();j++){
                if(map.containsKey(pattern.charAt(j)) && word.charAt(j) == map.get(pattern.charAt(j))){
                    continue;
                }else if(!map.containsKey(pattern.charAt(j)) && !set.contains(word.charAt(j))){
                    map.put(pattern.charAt(j), word.charAt(j));
                    set.add(word.charAt(j));
                }
                else{
                    match = false;
                    break;
                }
            }
            if(match)
                result.add(word);
        }
        return result;
    }
}
