package CP_6_3;

import Template.template;

import java.io.*;
import java.util.StringTokenizer;

public class JimmysRiddles_UVa10058 {
    static final String VERB = "(hate|love|know|like)s*";
    static final String NOUN = "(tom|jerry|goofy|mickey|jimmy|dog|cat|mouse)";
    static final String ARTICLE = "(a|the)";
    static final String ACTOR = "("+NOUN +"|"+ ARTICLE +" "+ NOUN+")";
    static final String ACTIVE_LIST = "("+ACTOR+" and )*" + ACTOR;
    static final String ACTION = ACTIVE_LIST +" "+ VERB+" "+ ACTIVE_LIST;
    static final String STATEMENT = ACTION+"( , "+ACTION +")*";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while(sc.ready()){
            String line = sc.nextLine().replaceAll("\\s+"," ").trim();
            System.out.println(line.matches(STATEMENT)?"YES I WILL":"NO I WON'T");
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



