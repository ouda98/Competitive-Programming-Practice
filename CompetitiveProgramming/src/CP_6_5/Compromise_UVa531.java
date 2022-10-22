package CP_6_5;

import Template.template;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Compromise_UVa531 {
    static Triple[][] memo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        while (sc.ready()) {
            ArrayList<String> first = new ArrayList<>();
            ArrayList<String> second = new ArrayList<>();
            int c = 2;
            while (c-- > 0) {
                while (true) {
                    String[] line = sc.nextLine().split(" ");
                    if (line[0].equals("#"))
                        break;
                    for (int i = 0; i < line.length; i++) {
                        if (c == 1)
                            first.add(line[i]);
                        else
                            second.add(line[i]);
                    }

                }
            }
            memo = new Triple[first.size()+1][second.size()+1];
            for(int i = 0;i<=first.size();i++){
                for(int j=0;j<=second.size();j++){
                    if(i==0 || j==0)
                        memo[i][j] = new Triple(0,i-1,j-1);

                    else if(first.get(i-1).equals(second.get(j-1)))
                        memo[i][j] = new Triple(memo[i - 1][j - 1].value+1,i-1,j-1);
                    else{
                        if(memo[i-1][j].value>memo[i][j-1].value){
                            memo[i][j] = new Triple(memo[i-1][j].value,i-1,j);
                        }else
                            memo[i][j] = new Triple(memo[i][j-1].value,i,j-1);

                    }
                }
            }
            ArrayList<String> res = new ArrayList<>();
            int r = first.size();
            int l = second.size();
            while(r>=0 && l>=0){
                int px = memo[r][l].x;
                int py = memo[r][l].y;
                if(r-px==1 && l-py==1 && px>=0 && py>=0) {
                    res.add(first.get(px));
                }
                r=px;
                l=py;
            }
            for(int i=res.size()-1;i>=0;i--){
                if(i==0)
                    System.out.println(res.get(i));
                else
                    System.out.print(res.get(i)+" ");
            }


        }

        out.flush();
        out.close();
    }

    static class Triple{
        int value;
        int x;
        int y;

        public Triple(int value, int x, int y){
            this.value = value;
            this.x =x;
            this.y = y;
        }
        public String toString(){
            return value+" "+x+" "+y;
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



