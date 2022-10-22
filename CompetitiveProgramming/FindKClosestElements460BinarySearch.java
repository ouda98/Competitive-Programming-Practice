import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindKClosestElements460BinarySearch {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int []A = {1,10,15,25,35,45,50,59};
        int target = 30;
        int k=7;
//        if(A.length==0)
//            return new int[k];
        int c = binarySearch(A,0,A.length-1,target);

        int differnce = Math.abs(target-A[c]);
        int index = c;
        if(c>0 && differnce >= Math.abs(target-A[c-1])){
            differnce = Math.abs(target-A[c-1]);
            index = c-1;
        }
        if(c<A.length-1 && differnce > Math.abs(target-A[c+1])){
            differnce = Math.abs(target-A[c+1]);
            index = c+1;
        }
        int []result = new int [k];
        int counter = 0;
        result[counter++] = A[index];
        int lowIdx = index-1;
        int highIdx = index+1;
        while(counter<k){
            if(lowIdx>=0 && highIdx<A.length){
                if(Math.abs(A[lowIdx]-target) <= Math.abs(A[highIdx]-target))
                    result[counter++] = A[lowIdx--];
                else if(Math.abs(A[lowIdx]-target) > Math.abs(A[highIdx]-target))
                    result[counter++] = A[highIdx++];

            }else if(lowIdx>0)
                result[counter++] = A[lowIdx--];
            else if(highIdx<A.length)
                result[counter++] = A[highIdx++];
        }
        System.out.println(Arrays.toString(result));


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


