package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSpanningTree {
    public static void main(String[] args) {

    }
    public static class Triple implements Comparable{
        int from;
        int to;
        int weight;
        public Triple(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public String toString(){
            return "from "+from+" to "+ to +" weight "+weight;
        }
        public int compareTo(Object o){
            return Integer.compare(this.weight, ((Triple) o).weight);
        }
    }
    public static class UFDS{
        int[] p;
        int[] rank;
        public UFDS(int n){
            p = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++)
                p[i] = i;
        }
        public int findParent(int i){
            if(i==p[i])
                return i;
            p[i] = findParent(p[i]);
            return p[i];
        }
        public int unionSet(int i, int j,int weight){
            int x = findParent(i);
            int y = findParent(j);
            if(x == y)
                return 0;
            if(rank[x]>rank[y])
                p[y] = x;
            else{
                p[x] = y;
                if(rank[x] == rank[y])
                    rank[y]++;
            }
            return weight;
        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        List<Triple> list = new ArrayList<Triple>();
        int i=0;
        for(ArrayList<ArrayList<Integer>> r :adj){
            for(ArrayList<Integer> e:r)
                list.add(new Triple(i,e.get(0),e.get(1)));
            i++;
        }
        Collections.sort(list);
        UFDS set = new UFDS(V);
        int total = 0;
        for(Triple t: list){
            total+= set.unionSet(t.from,t.to,t.weight);
        }
        return total;
    }
}
