package GeeksForGeeks;

public class UnionFind {
    public static void main(String[] args) {

    }
    public int findParent(int i,int []par){
        if(par[i] == i)
            return i;
        par[i] = findParent(par[i],par);
        return par[i];
    }
    public void union_(int a, int b, int par[], int rank[])
    {
        // add your code here
        int x = findParent(a,par);
        int y = findParent(b,par);
        if(x == y)
            return;
        if(rank[x] > rank[y])
            par[y] = x;
        else{
            par[x] = y;
            if(rank[x] == rank[y])
                rank[y]++;
        }
    }
    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        return findParent(a,par) == findParent(b,par);
    }
}
