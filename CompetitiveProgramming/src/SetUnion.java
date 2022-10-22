import java.util.HashMap;

public class SetUnion {
    public class Solution {
        /**
         * @param sets: Initial set list
         * @return: The final number of sets
         */
        public int setUnion(int[][] sets) {
            // Write your code here
            HashMap<Integer, Integer> map = new HashMap<>();
            UnionFind lists = new UnionFind(sets.length);
            System.out.println(lists.numberOfSets());

            for(int i=0;i<sets.length;i++){
                for(int j=0;j<sets[i].length;j++){
                    if(map.containsKey(sets[i][j])){
                        lists.unify(map.get(sets[i][j]),i);
                        System.out.println(map.get(sets[i][j])+" "+i);
                    }else{
                        map.put(sets[i][j],i);
                    }
                }
            }
            return lists.setNums;
        }

        public static class UnionFind{
            int setNums;
            int [] p;
            int [] setSize;
            int [] rank;
            public UnionFind(int n){
                this.setNums = n;
                this.p = new int[n];
                this.setSize = new int[n];
                this.rank = new int[n];
                for(int i=0;i<n;i++){
                    p[i] = i;
                    rank[i] = 0;
                    setSize[i] = 1;
                }
            }
            public int findParent(int i){
                if(p[i] == i)
                    return i;
                p[i] = findParent(p[i]);
                return p[i];
            }
            public boolean sameSet(int i, int j){
                return findParent(i) == findParent(j);
            }
            public int numberOfSets(){
                return setNums;
            }
            public void unify(int i, int j){
                if(sameSet(i,j))
                    return;
                int x = findParent(i);
                int y = findParent(j);
                setNums--;
                if(rank[x]> rank[y]){
                    p[y] = x;
                    setSize[x]+=setSize[y];
                }else{
                    p[x] = y;
                    setSize[y]+=setSize[x];
                    if(rank[x] == rank[y])
                        rank[y]++;
                }

            }
        }
    }
}
