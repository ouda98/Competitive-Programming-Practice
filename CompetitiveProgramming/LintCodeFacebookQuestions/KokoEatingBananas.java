package LintCodeFacebookQuestions;

public class KokoEatingBananas {
    public class Solution {
        /**
         * @param piles: an array
         * @param H: an integer
         * @return: the minimum integer K
         */
        public int minEatingSpeed(int[] piles, int H) {
            // Write your code here
            return bs(piles,H,0,(int)1e9);
        }
        public static int bs(int[] piles, int H, int l, int r){
            int min = -1;
            while(l<=r){
                int mid = l + (r-l)/2;

                long sum = valid(piles,mid,H);

                if(sum<=H){
                    min = mid;
                    r = mid-1;
                }else{
                    l = mid+1;
                }

            }
            return min;

        }

        public static long valid(int[] piles, int mid, int H){
            long sum =0;
            for(int i=0;i<piles.length;i++){
                sum += (int) Math.ceil(piles[i]/(mid*1.0));
            }
            return sum;
        }
    }
}
