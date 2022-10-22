import java.io.*;
import java.util.StringTokenizer;

public class TheJudgesGiveProblem963BSOnAnswer {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long E=0;
        long EM=0;
        long M=0;
        long MH=0;
        long H=0;

        System.out.println(binarySearch(E,EM,M,MH,H,0,(long)1e19));

        out.flush();
        out.close();
    }
    public static long binarySearch(long E, long EM, long M, long MH, long H, long l, long r){
        long max = 0;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(can(E,EM,M,MH,H,mid)){
                max = mid;
                l = mid+1;
            }
            else
                r = mid-1;


        }
        return max;
    }
    public static boolean can(long E, long EM, long M, long MH, long H, long mid){
        long result=0;
        if(E+EM>=mid){
            if(E<mid){
                result = (E+EM)-mid;
            }else{
                result = EM;
            }
            if(result+M+MH>=mid){
                if(result+M>mid){
                    result = MH;
                }
                else{
                    result = (result+M+MH)- mid;
                }
            }else
                return false;
            if(result+H>=mid){
                return true;
            }


        }
        return false;
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



