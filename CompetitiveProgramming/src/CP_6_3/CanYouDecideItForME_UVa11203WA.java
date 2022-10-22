package CP_6_3;

import java.io.*;
import java.util.StringTokenizer;

public class CanYouDecideItForME_UVa11203WA {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int f = -1;
            String line = sc.nextLine();
            int count1 = 0;
            int count2 = 0;
            int i = 0;
            for (; i < line.length(); i++) {
                if (line.charAt(i) == 'M')
                    f = 0;
                else if (line.charAt(i) == 'E') {
                    f += 1;
                    break;
                } else if (f == -1 && line.charAt(i) == '?')
                    count1++;
                else if (f == 0 && line.charAt(i) == '?')
                    count2++;


            }

//            System.out.println(f + " " + count2 + " " + count1);

            if (f !=1 || count1 < 1 || count2 <1) {
                System.out.println("no-theorem");
                continue;
            }

            i++;
            int count3 = 0;

            for (; i < line.length(); i++) {
                if (line.charAt(i) == '?')
                    count3++;
                else {
                    count3 = -1;
                    break;
                }
            }

            if (count3 == (count1 + count2))
                System.out.println("theorem");
            else
                System.out.println("no-theorem");

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


