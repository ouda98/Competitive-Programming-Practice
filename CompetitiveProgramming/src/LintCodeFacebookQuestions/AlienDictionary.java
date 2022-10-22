package LintCodeFacebookQuestions;

import java.util.HashMap;

public class AlienDictionary {
    public class Solution {

        public boolean isAlienSorted(String[] words, String order) {
            // write your code here.
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<order.length();i++){
                map.put(order.charAt(i),i);
            }
            for(int i=0;i<words.length-1;i++){
                String first = words[i];
                String second = words[i+1];
                int j;
                for(j=0;j< Math.min(first.length(),second.length());j++){
                    if(map.get(second.charAt(j))-map.get(first.charAt(j)) < 0)
                        return false;
                    if(second.charAt(j) != first.charAt(j)){
                        break;
                    }

                }
                if(second.length() < first.length() && j == Math.min(first.length(),second.length()))
                    return false;
            }

            return true;
        }
    }
}
