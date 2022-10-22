package CP_4_2_1_2BFS_DFS;

import Template.template;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class WeddingOfSultan_UVa12582 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        int c = 1;
        while(cases-- > 0){
            String line = sc.nextLine();
            ArrayList<Pair> output = new ArrayList<Pair>();
            Stack<Pair> stack = new Stack<Pair>();
            stack.push(new Pair(line.charAt(0),0));

            for(int i=1;i<line.length();i++){
                if(stack.peek().c == line.charAt(i))
                    output.add(stack.pop());
                else{
                    Pair temp = stack.pop();
                    stack.push(new Pair(temp.c, temp.n +1));
                    stack.push(new Pair(line.charAt(i),1));
                }
            }
            Collections.sort(output);
            out.println("Case "+ c++);
            for(int i=0;i<output.size();i++){
                out.println(output.get(i).c+" = "+output.get(i).n);
            }

        }


        out.flush();
        out.close();
    }

    public static class Pair implements Comparable<Pair>{
        char c;
        int n;
        public Pair(char c, int n){
            this.c = c;
            this.n = n;
        }

        public int compareTo(Pair other){
            return this.c - other.c;
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


