public class FindFriendCircleNumber {
    public class Solution {
        /**
         * @param M: a matrix of integer
         * @return: return an Integer
         */
        static int [] dr = {0,0,1,-1};
        static int [] dc = {1,-1,0,0};
        public int findCircleNum(int[][] M) {
            // write your code here
            int result =0;
            UnionFind friends = new UnionFind(M.length);
            for(int i=0;i<M.length;i++){
                for(int j=0;j<i;j++){
                    if(M[i][j]==1)
                        friends.unify(i,j);
                }
            }
            return friends.numberOfSets();
        }
        public static class UnionFind{
            int setNums;
            int [] parents;
            int [] rank;
            int [] setSize;
            public UnionFind(int n){
                this.setNums = n;
                this.parents = new int[n];
                this.rank = new int [n];
                this.setSize = new int [n];
                for(int i=0;i<n;i++){
                    parents[i] = i;
                    rank[i] = 0;
                    setSize[i] = 1;
                }
            }
            public boolean sameSet(int num1, int num2){
                return findParent(num1) == findParent(num2);
            }
            public int findParent(int num){
                if(parents[num] == num)
                    return num;
                parents[num] = findParent(parents[num]);
                return parents[num];
            }
            public void unify (int num1, int num2){
                if(sameSet(num1,num2))
                    return;
                int parent1 = findParent(num1);
                int parent2 = findParent(num2);
                setNums--;
                if(rank[parent1]>rank[parent2]){
                    parents[parent2] = parent1;
                    setSize[parent1]+= setSize[parent2];
                }else{
                    parents[parent1] = parent2;
                    setSize[parent2]+= setSize[parent1];
                    if(rank[parent1] == rank[parent2])
                        rank[parent2]++;
                }
            }
            public int numberOfSets(){
                return setNums;
            }
        }
    }
}
