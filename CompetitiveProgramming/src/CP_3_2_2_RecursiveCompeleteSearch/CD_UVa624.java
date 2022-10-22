package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class CD_UVa624 {
    static int [] arr;
    static int target;
    static String result="";
    static int diff;
    static int closeSum =0;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()){
            diff =(int)1e9;
            target = sc.nextInt();
            int n = sc.nextInt();
            arr = new int[n];
            for(int i=0;i<arr.length;i++)
                arr[i] = sc.nextInt();

            solve("",0,0);
            System.out.println(result+"sum:"+closeSum);

        }

            out.flush();
            out.close();
        }

    private static void solve(String s, int idx, int sum) {
        if(idx==arr.length && target>=sum && target-sum<diff){
            diff = Math.abs(sum - target);
            result = s;
            closeSum = sum;
            return;
        }
        if(idx==arr.length)
            return;
        if(diff!=0) {

            solve(s + "" + arr[idx] + " ", idx + 1, sum + arr[idx]);
            solve(s, idx + 1, sum);
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



