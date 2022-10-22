import java.util.Arrays;

public class FindTheRank {
    public class Solution {
        /**
         * @param scores: two dimensional array
         * @param K: a integer
         * @return: return a integer
         */
        public int FindTheRank(int[][] scores, int K) {
            // write your code here
            Pair[] av = new Pair [scores.length];
            for(int i=0;i<scores.length;i++){
                double sum =0;
                for(int j=0;j<scores[i].length;j++){
                    sum+= scores[i][j];
                }
                av[i] = new Pair(i,sum/scores[i].length);
            }
            Arrays.sort(av);
            System.out.println(Arrays.toString(av));
            return av[K-1].pos;
        }
        public static class Pair implements Comparable<Pair>{
            int pos;
            double value;
            public Pair(int pos, double value){
                this.pos = pos;
                this.value = value;
            }
            public int compareTo(Pair other){
                return Double.compare(other.value, this.value);
            }
            public String toString(){
                return pos +" "+ value;
            }
        }
    }
}
