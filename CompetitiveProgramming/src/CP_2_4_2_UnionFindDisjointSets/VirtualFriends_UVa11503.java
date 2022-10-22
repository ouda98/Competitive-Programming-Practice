package CP_2_4_2_UnionFindDisjointSets;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class VirtualFriends_UVa11503 {
    static ArrayList<Tripe> people;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
        //        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cases = sc.nextInt();
        while(cases-->0){
            map.clear();
            int mapCount =0;
            people = new ArrayList<>();
            int friendships = sc.nextInt();
            int from;
            for(int i=0;i<friendships;i++){
                String[] line = sc.nextLine().split(" ");
                if(map.containsKey(line[0])){
                    from = map.get(line[0]);

                }else{
                    from = mapCount;
                    people.add(new Tripe(from,0,1));
                    map.put(line[0],mapCount);
                    mapCount++;
                }
                int to;
                if(map.containsKey(line[1])){
                    to = map.get(line[1]);
                }else {
                    to = mapCount;
                    people.add(new Tripe(to, 0, 1));
                    map.put(line[1], mapCount);
                    mapCount++;
                }
                int x = find(from);
                int y = find(to);
                if(x==y)
                    System.out.println(people.get(x).count);
                else
                    System.out.println(union(x,y));

            }
        }


        out.flush();
        out.close();
    }

    private static int union(int x, int y) {
        int root =0;
        int rootX = find(x);
        int rootY = find(y);
        if(people.get(rootX).rank<people.get(rootY).rank) {
            people.get(rootX).parent = rootY;
            people.get(rootY).count+= people.get(rootX).count;
            root = people.get(rootY).count;

        }else if(people.get(rootX).rank>people.get(rootY).rank){
            people.get(rootY).parent = rootX;
            people.get(rootX).count+= people.get(rootY).count;
            root = people.get(rootX).count;
        }

        else{
            people.get(rootY).parent = rootX;
            people.get(rootX).count+= people.get(rootY).count;
            root = people.get(rootX).count;
        }
        return root;
    }

    private static int find(int from) {
        if(people.get(from).parent != from)
            people.get(from).parent = find(people.get(from).parent);
        return people.get(from).parent;
    }

    static class Tripe{
        int parent;
        int rank;
        int count;
        public Tripe(int parent,int rank ,int count){
            this.parent=parent;
            this.rank=rank;
            this.count=count;
        }
        public String toString(){
            return "Parent "+parent+" rank "+rank+" count "+ count;
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}


