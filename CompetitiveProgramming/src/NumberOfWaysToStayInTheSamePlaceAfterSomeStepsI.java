public class NumberOfWaysToStayInTheSamePlaceAfterSomeStepsI {
    public class Solution {
        /**
         * @param steps: steps you can move
         * @param arrLen: the length of the array
         * @return: Number of Ways to Stay in the Same Place After Some Steps
         */
        static int counter;
        public int numWays(int steps, int arrLen) {
            // write your code here
            counter =0;
            dfs(steps,arrLen, 0);
            return counter;
        }
        public static void dfs(int steps, int arrLen, int pos){
            if(steps == 0 && pos == 0){
                counter++;
                return;
            }
            if(steps == 0)
                return;

            if(pos< arrLen-1)
                dfs(steps-1, arrLen, pos+1);
            if(pos>0)
                dfs(steps-1, arrLen, pos-1);
            dfs(steps-1, arrLen, pos);

        }
    }
}
