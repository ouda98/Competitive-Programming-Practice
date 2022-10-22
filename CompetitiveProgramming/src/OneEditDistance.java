public class OneEditDistance {
    public class Solution {
        /**
         * @param s: a string
         * @param t: a string
         * @return: true if they are both one edit distance apart or false
         */
        public boolean isOneEditDistance(String s, String t) {
            // write your code here
            if(s.equals(t) || Math.abs(t.length() - s.length())>1)
                return false;
            int index;
            for(int i=0;i<Math.min(s.length(),t.length());i++){
                index = i+1;
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(index).equals(t.substring(index))
                            || s.substring(index-1).equals(t.substring(index))
                            || s.substring(index).equals(t.substring(index-1));
                }
            }
            return true;
        }
    }
}
