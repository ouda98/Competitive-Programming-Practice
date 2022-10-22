import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param strs: the given array of strings
         * @return: The anagrams which have been divided into groups
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            // write your code here
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for(String i: strs){
                String sorted = sort(i);
                if(map.containsKey(sort(i))){
                    map.get(sorted).add(i);
                }else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(i);
                    map.put(sorted,list);
                }
            }
            List<List<String>> result = new ArrayList<>();
            for(String s: map.keySet()){
                ArrayList<String> value = map.get(s);
                result.add(value);
            }
            return result;
        }

        public static String sort(String input){
            char [] c = input.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
}
