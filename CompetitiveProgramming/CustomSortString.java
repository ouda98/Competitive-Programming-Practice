import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CustomSortString {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param S: The given string S
         * @param T: The given string T
         * @return: any permutation of T (as a string) that satisfies this property
         */
        public String customSortString(String S, String T) {
            // Write your code here
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<S.length();i++){
                set.add(S.charAt(i));
            }
            StringBuilder rest = new StringBuilder();
            for(int i=0;i<T.length();i++){
                if(!set.contains(T.charAt(i)))
                    rest.append(T.charAt(i));
            }
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<T.length();i++){
                if(map.containsKey(T.charAt(i))){
                    map.put(T.charAt(i),map.get(T.charAt(i))+1);
                }else{
                    map.put(T.charAt(i),1);
                }
            }
            StringBuilder result = new StringBuilder();
            for(int i=0;i<S.length();i++){
                if(map.containsKey(S.charAt(i))){
                    int rep = map.get(S.charAt(i));
                    while(rep-->0){
                        result.append(S.charAt(i));
                    }
                    map.remove(S.charAt(i));
                }

            }
            char[] chars = rest.toString().toCharArray();
            Arrays.sort(chars);

            return result.toString() + new String(chars);
        }
    }
}
