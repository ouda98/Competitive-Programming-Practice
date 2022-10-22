public class FindIfPathExistsInGraph {
    public static void main(String[] args) {

    }
    public class UFDS{
        int[] p;
        int[] rank;
        public UFDS(int n){
            p = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
                p[i] = i;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UFDS set = new UFDS(n);
        for(int i=0;i<edges.length;i++){
            unionSet(edges[i][0],edges[i][1],set);
        }
        return findParent(source,set) == findParent(destination,set);
    }
    public void unionSet(int i, int j, UFDS set){
        int x = findParent(i,set);
        int y = findParent(j,set);
        if(x == y)
            return;
        if(set.rank[x]>set.rank[y])
            set.p[y] = x;
        else{
            set.p[x] = y;
            if(set.rank[x] == set.rank[y])
                set.rank[y]++;
        }
    }
    public int findParent(int i, UFDS set){
        if(set.p[i] == i)
            return i;
        set.p[i] = findParent(set.p[i],set);
        return set.p[i];
    }
}
