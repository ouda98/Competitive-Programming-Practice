import java.util.ArrayList;

public class DetectCycleUsingDSU {
    public static void main(String[] args) {

    }
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        UnionFind set = new UnionFind(adj.size());
        for(int i=0;i<adj.size();i++)
            for(int j=0;j<adj.get(i).size();j++){
                if(set.isSameSet(i,adj.get(i).get(j)))
                    return 1;
                set.unionSet(i,adj.get(i).get(j));
            }
        return 0;
    }
    public class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<parent.length;i++)
                parent[i] = i;
        }
        public int findParent(int i){
            if(parent[i] == i)
                return i;
            return findParent(parent[i]);
        }
        public boolean isSameSet(int x, int y){
            return findParent(x) == findParent(y);
        }
        public void unionSet(int i, int j){
            int x = findParent(i);
            int y = findParent(j);
            if(isSameSet(x,y))
                return;
            if(rank[x] > rank[y])
                parent[y] = x;
            else{
                rank[x] = y;
                if(rank[x] == rank[y])
                    rank[y]++;
            }
        }
    }
}
