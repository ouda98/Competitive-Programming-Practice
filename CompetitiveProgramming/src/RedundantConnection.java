public class RedundantConnection {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int [] result = new int[2];
            UnionFind nodes = new UnionFind(1000);
            for(int i = 0;i < edges.length; i++){
                int from = edges[i][0];
                int to = edges[i][1];
                if(!nodes.sameSet(from,to)){
                    nodes.unify(from,to);
                }else{
                    result[0] = from;
                    result[1] = to;
                }
            }
            return result;

        }

        public static class UnionFind{
            int[] rank;
            int [] parent;
            int setNums;
            public UnionFind(int n){
                setNums = n;
                rank = new int[n+1];
                parent = new int[n+1];
                for(int i=0;i<=n;i++){
                    rank[i] = 0;
                    parent[i] = i;
                }
            }

            public int findParent(int i){
                if(parent[i] == i)
                    return i;
                parent[i] = findParent(parent[i]);
                return parent[i];
            }

            public boolean sameSet(int i, int j){
                return findParent(i) == findParent(j);
            }

            public void unify(int i,int j){
                if(sameSet(i, j))
                    return;
                int x = findParent(i);
                int y = findParent(j);
                setNums--;
                if(rank[x]>rank[y]){
                    parent[y] = x;
                }else{
                    parent[x] = y;
                    if(rank[x] == rank[y]) rank[y]++;
                }
            }
        }
    }
}
