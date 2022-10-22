package LintCodeFacebookQuestions;

import java.util.PriorityQueue;

public class KthSmallestElementInASpecificArray {
    public class Solution {
        /**
         * @param arr: an array of integers
         * @param k: an integer
         * @return: the Kth smallest element in a specific array
         */
        public int kthSmallest(int[][] arr, int k) {
            // write your code here
            PriorityQueue<Pair> q = new PriorityQueue<>();
            for(int i=0;i<arr.length;i++){
                if(arr[i].length>0)
                    q.add(new Pair(arr[i][0],i,0));
            }
            Pair p = new Pair(0,0,0);
            while(true){
                if(k==1)
                    return q.poll().number;
                if(k>1){
                    p = q.poll();
                    if(arr[p.array].length>p.position+1)
                        q.add(new Pair(arr[p.array][p.position+1],p.array,p.position+1));
                    k--;
                }
            }
        }

        static class Pair implements Comparable<Pair>{
            int number;
            int array;
            int position;
            public Pair(int number, int array, int position){
                this.number = number;
                this.array = array;
                this.position = position;
            }
            public int compareTo(Pair o){
                return this.number - o.number;
            }
            public String toString(){
                return number+" "+ array+" "+ position;
            }
        }


    }
}
