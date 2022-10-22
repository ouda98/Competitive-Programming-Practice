package CP_6_3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PasswordSearch_UVa902 {
    static HashMap<String,Integer> set = new HashMap<>();
    static int max;
    static String s;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");


        while (sc.ready()) {
            int length = sc.nextInt();
            String line = sc.next();
            String sub;
            max =0;
            s = "";
            set.clear();

            for (int i = 0; i < line.length() - length + 1; i++) {
                sub = line.substring(i, length + i);
                add(sub);
            }

            System.out.println(s);



        }


        out.flush();
        out.close();
    }

    private static void add(String sub) {
        if(set.containsKey(sub)) {
            set.put(sub, set.get(sub) + 1);
            if(max<set.get(sub)){
                max = set.get(sub);
                s = sub;
            }

        }
        else
            set.put(sub,1);
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


