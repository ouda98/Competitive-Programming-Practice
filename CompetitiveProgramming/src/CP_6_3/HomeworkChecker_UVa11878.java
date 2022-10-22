package CP_6_3;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HomeworkChecker_UVa11878 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int counter =0;
        while(sc.ready()){
            String in = sc.nextLine();
            int sign = 0;
            for(int i=0;i<in.length();i++){
                if(in.charAt(i)=='+')
                    sign = 1;
                if(in.charAt(i)=='-')
                    sign = 2;
            }
            String[] line = in.split("[+=-]");
            if(line[2].charAt(0)=='?')
                continue;
            int one = Integer.parseInt(line[0]);
            int two = Integer.parseInt(line[1]);
            int three = Integer.parseInt(line[2]);
            if(sign==1 && one+two ==three)
                counter++;
            if(sign==2 && one-two==three)
                counter++;


        }
        System.out.println(counter);


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



