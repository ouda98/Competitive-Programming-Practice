import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinimumSpanningTree {

    public class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public class Solution {
        /**
         * @param connections given a list of connections include two cities and cost
         * @return a list of connections from results
         */
        static HashMap<String, Integer> map;
        static HashMap<Integer, String> revMap;

        public List<Connection> lowestCost(List<Connection> connections) {
            // Write your code here
            map = new HashMap<>();
            revMap = new HashMap<>();
            List<Triple> list = new ArrayList<>();
            int counter = 0;
            for (int i = 0; i < connections.size(); i++) {
                String city1 = connections.get(i).city1;
                String city2 = connections.get(i).city2;
                int from;
                int to;
                if (map.containsKey(city1)) {
                    from = map.get(city1);
                } else {
                    map.put(city1, counter);
                    revMap.put(counter, city1);
                    from = counter;
                    counter++;
                }
                if (map.containsKey(city2)) {
                    to = map.get(city2);
                } else {
                    map.put(city2, counter);
                    revMap.put(counter, city2);
                    to = counter;
                    counter++;
                }

                list.add(new Triple(from, to, connections.get(i).cost));
            }
            UFDS roads = new UFDS(counter--);

            Collections.sort(list);
            List<Connection> result = new ArrayList<>();
            int from;
            int to;
            int cost;
            for (int i = 0; i < list.size(); i++) {
                from = list.get(i).from;
                to = list.get(i).to;
                cost = list.get(i).weight;
                if (roads.findParent(from) != roads.findParent(to)) {
                    roads.unifySets(from, to);

                    result.add(new Connection(revMap.get(from), revMap.get(to), cost));
                }
            }
            if (roads.numberOfSets() == 1)
                return result;
            return new ArrayList<>();


        }


        public static class UFDS {
            int setnum;
            int[] p;
            int[] rank;
            int[] setSize;

            public UFDS(int n) {
                this.setnum = n;
                this.p = new int[n];
                this.rank = new int[n];
                this.setSize = new int[n];
                for (int i = 0; i < n; i++) {
                    p[i] = i;
                    rank[i] = 0;
                    setSize[i] = 1;
                }
            }

            public void unifySets(int i, int j) {
                if (findParent(i) == findParent(j))
                    return;
                int x = findParent(i);
                int y = findParent(j);

                setnum--;

                if (rank[x] > rank[y]) {
                    p[y] = x;
                    setSize[x] += setSize[y];
                } else {
                    p[x] = y;
                    setSize[y] += setSize[x];
                    if (rank[x] == rank[y])
                        rank[y]++;
                }
            }

            public boolean sameSet(int i, int j) {
                return findParent(i) == findParent(j);
            }

            public int numberOfSets() {
                return setnum;
            }


            public int findParent(int i) {
                if (p[i] == i)
                    return p[i];
                p[i] = findParent(p[i]);
                return p[i];
            }


        }

        public static class Triple implements Comparable<Triple> {
            int from;
            int to;
            int weight;

            public Triple(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            public int compareTo(Triple other) {
                if (this.weight == other.weight) {
                    if (revMap.get(this.from).equals(revMap.get(other.from))) {
                        return revMap.get(this.to).compareTo(revMap.get(other.to));
                    } else {
                        return revMap.get(this.from).compareTo(revMap.get(other.from));
                    }

                }

                return this.weight - other.weight;
            }
        }
    }
}
