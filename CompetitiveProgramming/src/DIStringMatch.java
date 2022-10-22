public class DIStringMatch {
    public class Solution {
        public int[] diStringMatch(String S) {
            if(S.length() == 0)
                return new int[0];
            int [] result = new int [S.length()+1];
            int increase = 0;
            int decrease = S.length();
            for(int i=0;i<S.length();i++){
                if(S.charAt(i)=='I')
                    result[i] = increase++;
                else
                    result[i] = decrease--;
            }
            result[result.length-1] = decrease;
            return result;
        }
    }
}
