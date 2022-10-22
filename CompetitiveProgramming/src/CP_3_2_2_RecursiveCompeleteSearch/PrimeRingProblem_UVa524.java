package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PrimeRingProblem_UVa524 {
    static int size;
    static int [] circle;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        set.add(29);
        set.add(31);
        int c=1;
        boolean f = false;
        while (sc.ready()){
            if (f)
                System.out.println();
            f = true;
            size =sc.nextInt();
            circle = new int[size];
            circle[0]=1;
            System.out.println("Case "+c+++":");
            solve(1);

        }


            out.flush();
            out.close();
        }

    private static void solve(int idx) {
        if(idx==size && set.contains(circle[0]+circle[size-1])) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<size;i++)
                if(i==0)
                    sb.append(circle[i]);
                else
                    sb.append(" "+circle[i]);
            System.out.println(sb);

            return;
        }
        if(idx==size)
            return;

        for(int i=2;i<=size;i++){
            if(place(i,idx)){
                circle[idx] = i;
                solve(idx+1);
            }

        }

    }

    private static boolean place(int r, int idx) {
        for(int i=0;i<idx;i++){
            if(circle[i]==r || !set.contains(r+circle[idx-1]))
                return false;
        }
        return true;
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



