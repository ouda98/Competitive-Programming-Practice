import java.util.HashMap;
import java.util.List;

public class TheCandidateWithTheMostVotes {
    public static void main(String[] args) {

    }
    public class Solution {
        /**
         * @param votes: The array of names of candidates in the election.
         * @return: The name of the candidate who has the most votes.
         */
        public String candidateWithTheMostVotes(List<String> votes) {
            // Write your code here
            HashMap<String,Integer> map = new HashMap<>();
            for(String s : votes){
                if(map.containsKey(s))
                    map.put(s, map.get(s)+1);
                else
                    map.put(s, 1);
            }
            String result = "";
            int min = 0;
            for(String s: map.keySet()){
                System.out.println(s);
                if(map.get(s)>min){
                    min = map.get(s);
                    result = s;
                }
                else if(map.get(s)== min){
                    result = (s.compareTo(result)<0)?s:result;
                }
            }
            return result;
        }
    }
}
