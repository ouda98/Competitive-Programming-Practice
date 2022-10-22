import java.io.*;
import java.util.StringTokenizer;

public class ClosestNumberInSortedArray459BinarySearch {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int []A = {1,2,2,4,5,5};
        int target = 2;
        int c = binarySearch(A,0,A.length-1,target);
        if(A[c]== target) {
            System.out.println(c);
            return;
        }

        int differnce = Math.abs(target-A[c]);
        int index = c;
        if(c>0 && differnce > Math.abs(target-A[c-1])){
            differnce = Math.abs(target-A[c-1]);
            index = c-1;
        }
        if(c<A.length-1 && differnce > Math.abs(target-A[c+1])){
            index = c+1;
        }
        System.out.println(index);


        out.flush();
        out.close();
    }
    private static int binarySearch(int[] a, int l, int r, int target) {
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            result = mid;
            if (a[mid] == target) {
                result = mid;
                break;
            }
            else if (a[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return result;
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


