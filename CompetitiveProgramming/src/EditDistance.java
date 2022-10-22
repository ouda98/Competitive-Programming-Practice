public class EditDistance {
    public class Solution {
        /**
         * @param word1: A string
         * @param word2: A string
         * @return: The minimum number of steps.
         */
        public int minDistance(String word1, String word2) {
            // write your code here
            if(word1.length()==0)
                return word2.length();
            if(word2.length()==0)
                return word1.length();
            int [][] dp = new int[word1.length()+1][word2.length()+1];

            for(int i=0;i<=word1.length();i++){
                for(int j=0;j<=word2.length();j++){
                    if(i==0)
                        dp[i][j] = j;
                    else if(j==0)
                        dp[i][j] = i;

                    else if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else{
                        dp[i][j] = min(dp,i,j)+1;
                    }

                }
            }
            // for(int i=0;i<dp.length;i++)
            //     System.out.println(Arrays.toString(dp[i]));
            return dp[word1.length()][word2.length()];
        }
        public static int min(int [][] dp,int i, int j){
            int one = dp[i-1][j-1];
            int two = dp[i][j-1];
            int three = dp[i-1][j];
            return Math.min(one,Math.min(two,three));
        }
    }
}
