package CP_6_3;

import java.io.*;
import java.util.StringTokenizer;

public class DecodeTheTape_UVa10878 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");


        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder letter;
        String line;
        while (true) {
            line = sc.nextLine();
            if (line.charAt(0) == '_')
                break;
            letter = new StringBuilder();
            for (int i = 1; i < line.length() - 1; i++) {

                if (line.charAt(i) == 'o')
                    letter.append("1");
                else if(line.charAt(i)==' ')
                    letter.append("0");
            }

//            System.out.print((char) Integer.parseInt(letter.toString(), 2));
//            System.out.println("   "+letter);

            if(letter.toString().equals("00001101")) {
//                System.out.print((char) Integer.parseInt("1010", 2));
                sb.append((char) Integer.parseInt("1010", 2));

            }

            sb.append((char) Integer.parseInt(letter.toString(), 2));


        }
        System.out.println(sb.substring(0,sb.length()-1));

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



