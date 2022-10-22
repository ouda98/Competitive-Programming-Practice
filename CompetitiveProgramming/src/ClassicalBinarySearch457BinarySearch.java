import java.io.*;
import java.util.StringTokenizer;

public class ClassicalBinarySearch457BinarySearch {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int [] a = {1,2,2,2,2,3,3,4,5};
        int target = 20;
        int c= binarySearch(a,0, a.length-1,target);
        System.out.println(c);


        out.flush();
        out.close();
    }

    private static int binarySearch(int[] a, int l, int r, int target) {
        if(l<=r){
            int mid = l+(r-l)/2;

            if(a[mid]==target)
                return mid;
            if(a[mid]<target)
                return binarySearch(a,mid+1,r,target);
            else
                return binarySearch(a,l,mid-1,target);
        }
        return -1;
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


