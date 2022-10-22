package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class SocialConstraints_UVa11742 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");

        while (sc.ready()) {
            int n = sc.nextInt();
            int co = sc.nextInt();
            Triple[] con = new Triple[co];
            for(int i=0;i<co;i++)
                con[i] = new Triple(sc.nextInt(), sc.nextInt(), sc.nextInt());
            if (n == 0)
                break;
            int[] num = new int[n];
            for (int i = 0; i < n; i++)
                num[i] = i;
            int first, second, c;
            boolean f = false;
            int p1=0,p2=0;
            int res =0;
            do{
                int subr =0;
                f = false;
                for(int i=0;i<con.length && !f;i++){
                    first = con[i].first;
                    second = con[i].second;
                    c = con[i].c;
                    for(int j=0;j<num.length && !f;j++){
                        if(num[j]==first)
                            p1 = j;
                        else if(num[j]==second)
                            p2 = j;
                    }
                    if(c>=0 && Math.abs(p1-p2) <= c)
                        subr++;
                    else if(c<0 && Math.abs(p1-p2) >= Math.abs(c))
                        subr++;
                    else
                        f = true;
                }
                if(subr==co)
                    res++;

            }
            while (findsNextPermutation(num));
            System.out.println(res);



        }
        out.flush();
        out.close();
    }

    //the user-defined function finds all the permutation greater than the number itself
    static boolean findsNextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1; ; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }
    public static class Triple{
        int first;
        int second;
        int c;
        public Triple(int first, int second, int c){
            this.first = first;
            this.second = second;
            this.c = c;
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



