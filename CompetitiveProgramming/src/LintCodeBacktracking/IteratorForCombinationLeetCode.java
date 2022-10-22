package LintCodeBacktracking;

import java.util.ArrayList;

public class IteratorForCombinationLeetCode {
    class CombinationIterator {
        String characters;
        int combinationLength;
        int counter = 0;
        static ArrayList<String> s = new ArrayList();

        public CombinationIterator(String characters, int combinationLength) {
            s = new ArrayList();
            counter =0;
            this.characters = characters;
            this.combinationLength = combinationLength;
            solve(0,0,characters,"",combinationLength);
        }

        public String next() {
            return s.get(counter++);

        }

        public boolean hasNext() {
            return s.size()>counter;

        }
        public static void solve(int idx,int sum,String in,String r, int n){
            if(sum == n && idx==in.length()){
                s.add(r);
                return;
            }
            if(idx==in.length())
                return;
            solve(idx+1,sum+1,in,r+in.charAt(idx),n);
            solve(idx+1,sum,in,r,n);
        }

    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
