import java.util.ArrayList;
import java.util.List;

public class NoPairsAllowed {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param words: The array words that you need to calculate minimal operation .
         * @return: Return an array of integers, each result[i] being the minimum operations needed to fix words[i].
         */
        public List<Integer> minimalOperation (List<String> words) {
            // Write your code here.
            List<Integer> result = new ArrayList<>();
            boolean d = false;
            int counter =0;
            for(int i=0;i<words.size();i++){
                d = false;
                counter = 0;
                for(int j=0;j<words.get(i).length()-1;j++){
                    if(words.get(i).charAt(j) == words.get(i).charAt(j+1)){
                        d = true;
                        counter++;
                        j++;
                    }
                }
                if(!d)
                    result.add(0);
                else
                    result.add(counter);
            }
            return result;
        }
    }
}
