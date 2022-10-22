import java.io.*;
import java.util.StringTokenizer;

public class HowManyProblemCanIAccept937BSOnAnswer {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int sum =0;
        int counter =1;
        long n=0;
        int k =0;
        System.out.println(binarySearch(n,k,0,(long)Math.sqrt(n)*2));

        out.flush();
        out.close();
    }
    public static long binarySearch(long n, int k, long l,long r){
        long max =0;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(can(n,k,mid)){
                max = mid;
                l= mid+1;
            }
            else
                r = mid -1;

        }
        return max;
    }
    public static boolean can(long n, int k , long mid){
        long sum = ((mid*(mid+1))/2) *k;
        if(sum>n)
            return false;

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


