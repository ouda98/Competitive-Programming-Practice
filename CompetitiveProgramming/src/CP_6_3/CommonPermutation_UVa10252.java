package CP_6_3;

import Template.template;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CommonPermutation_UVa10252 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            char[] first = sc.nextLine().toCharArray();
            Arrays.sort(first);
            char[] second = sc.nextLine().toCharArray();
            Arrays.sort(second);


            int j=0;
            int z =0;
            StringBuilder sb = new StringBuilder();
            while(true){
                if(j>= first.length || z>=second.length)
                    break;
                if(first[j]<second[z])
                    j++;
                else if(first[j]>second[z])
                    z++;
                else{
                    sb.append(second[z]);
                    j++;
                    z++;
                }

            }

            System.out.println(sb);


        }

        out.flush();
        out.close();
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


