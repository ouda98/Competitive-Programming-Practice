package CP_6_3;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Formula1_UVA11056 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()){
            int n = sc.nextInt();
            All[] rows = new All[n];

            for(int i=0;i<n;i++){
                String[] line = sc.nextLine().split(":");
                String [] in = line[1].trim().split(" ");
                rows[i] = new All(line[0].trim(),Integer.parseInt(in[0]),Integer.parseInt(in[2]),Integer.parseInt(in[4]));
            }

            Arrays.sort(rows);
            int c =1;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    System.out.println("Row "+c++);
                }
                System.out.println(rows[i].name);
            }
            System.out.println();


        }
        out.flush();
        out.close();
    }

    static class All implements Comparable<All>{
        String name;
        int minutes;
        int seconds;
        int mile;

        public All(String name, int minutes, int seconds, int mile){
            this.name = name;
            this.minutes = minutes;
            this.seconds = seconds;
            this.mile = mile;
        }

        public String toString(){
            return name +" "+ minutes+" "+seconds+" "+ minutes;
        }

        public int compareTo(All o){
            if(this.minutes==o.minutes)
                if(this.seconds==o.seconds)
                    if(this.mile == o.mile)
                        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
                    else
                        return this.mile-o.mile;
                else
                    return this.seconds-o.seconds;

            return this.minutes - o.minutes;
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
