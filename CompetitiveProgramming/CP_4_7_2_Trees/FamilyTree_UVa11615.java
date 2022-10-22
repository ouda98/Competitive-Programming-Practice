package CP_4_7_2_Trees;

import java.io.*;
import java.util.StringTokenizer;

public class FamilyTree_UVa11615 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        while (cases-->0){
            int generations = sc.nextInt();
            int total =(int) Math.pow(2,generations)-1;
            int bro1 = sc.nextInt();
            int bro2 = sc.nextInt();
            int leastBro = Math.max(bro1,bro2);
            int b = (int)Math.floor(Math.log(leastBro) / Math.log(2)) +1;
            if(b==generations)
                System.out.println(total);
            else{
                total -= Math.pow(2,1+generations-b)-2;
                System.out.println(total);
            }

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



