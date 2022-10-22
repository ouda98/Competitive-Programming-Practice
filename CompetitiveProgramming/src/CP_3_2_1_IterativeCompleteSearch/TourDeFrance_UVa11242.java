package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TourDeFrance_UVa11242 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            int frontN = sc.nextInt();
            if (frontN==0)
                return;
            int rearN = sc.nextInt();
            int [] front = new int[frontN];
            for(int i = 0;i< frontN;i++)
                front[i] = sc.nextInt();

            int totalRatios = frontN*rearN;
            double [] ratios = new double[totalRatios];

            for(int i=0;i<rearN;i++){
                int r = sc.nextInt();
                for(int j=0;j<frontN;j++){
                    ratios[j+(i*frontN)] = r/(front[j]*1.0);
                }

            }
            Arrays.sort(ratios);
            double spread =0;
            for(int i=0;i<totalRatios-1;i++){
                    double max = ratios[i+1];
                    double min = ratios[i];
                    if(spread<(max/min))
                        spread = (max/min);
            }
            System.out.printf("%.2f", spread);
            System.out.println();
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



