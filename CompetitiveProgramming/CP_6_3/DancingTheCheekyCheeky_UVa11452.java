package CP_6_3;


import java.io.*;
import java.util.StringTokenizer;

public class DancingTheCheekyCheeky_UVa11452 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        int cases = sc.nextInt();
        String dance = "";

        while (cases-- > 0) {
            String line = sc.nextLine();
            int third = line.length() / 3;
            for (int i = third; i < line.length(); i++) {
                String max = line.substring(0, i);
                String rest = line.substring(i);
                if (rest.contains(max)) {
                    if (rest.indexOf(max) == 0)
                        dance = max;
                } else
                    break;
            }
            int j = 0;
            StringBuilder sb = new StringBuilder();


            for (int i = dance.length() * 2; i < line.length() + 8; i++) {
                if (i < line.length())
                    j++;
                else {
                    sb.append(dance.charAt((j++) % dance.length()));
                }
            }
            sb.append("...");
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



