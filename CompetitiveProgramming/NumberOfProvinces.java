public class NumberOfProvinces {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=i;j<isConnected.length;j++){
                if(j==i)
                    continue;
                if(isConnected[i][j] == 1){
                    uf.unionSet(i,j);
                }
            }
        }
        return uf.setSize;
    }
    public class UnionFind{
        int[] p;
        int[] rank;
        int setSize;
        public UnionFind(int n){
            setSize = n;
            rank = new int[n];
            p = new int[n];
            for(int i=0;i<p.length;i++)
                p[i] = i;
        }
        public int findParent(int i){
            if(p[i] == i)
                return i;
            return p[i] = findParent(p[i]);
        }
        public void unionSet(int i, int j){
            int x = findParent(i);
            int y = findParent(j);
            if(x == y)
                return;
            setSize--;
            if(rank[x]>rank[y])
                p[y] = x;
            else{
                p[x] = y;
                if(rank[x] == rank[y])
                    rank[y]++;
            }
        }
    }
}
