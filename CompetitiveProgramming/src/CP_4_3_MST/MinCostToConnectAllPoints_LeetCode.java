package CP_4_3_MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostToConnectAllPoints_LeetCode {
    public static void main(String[] args) {

    }
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int x,y;
            List<Triple> list = new ArrayList<>();
            for(int i=0;i<points.length;i++){
                x = points[i][0];
                y = points[i][1];
                for(int j= i+1;j<points.length;j++){
                    int newX = points[j][0];
                    int newY = points[j][1];
                    list.add(new Triple(i,j,Math.abs(x-newX)+ Math.abs(y-newY)));
                }
            }
            Collections.sort(list);
            UnionFind grid = new UnionFind(points.length);
            int counter =0;
            for(int i=0;i<list.size();i++){
                Triple top = list.get(i);
                if(!grid.sameSet(top.from, top.to)){
                    counter+=top.cost;
                    grid.unifySets(top.from,top.to);
                }

            }
            return counter;
        }

        public static class Triple implements Comparable<Triple>{
            int from;
            int to;
            int cost;
            public Triple(int from, int to, int cost){
                this.from = from;
                this.to = to;
                this.cost = cost;
            }

            public int compareTo(Triple other){
                return this.cost - other.cost;
            }
        }

        public static class UnionFind{
            int setsNum;
            int []p;
            int[] rank;
            public UnionFind(int n){
                this.setsNum = n;
                p = new int[n];
                rank = new int[n];
                for(int i=0;i<n;i++){
                    p[i] = i;
                    rank[i] = 0;
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
                return setsNum;
            }
            public void unifySets(int i, int j){
                if(sameSet(i,j))
                    return;
                int x = findParent(i);
                int y = findParent(j);
                setsNum--;
                if(rank[x]>rank[y]){
                    p[y] = x;
                }else{
                    p[x]= y;
                    if(rank[x] == rank[y])
                        rank[y]++;
                }
            }
        }
    }
}
