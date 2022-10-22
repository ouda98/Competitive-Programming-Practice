import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildATemple1669 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        List<Integer> woods = new LinkedList<>();
        woods.add(2);
        woods.add(10);
        int max =0;
        for(int i=0;i<woods.size();i++){
            if(woods.get(i)>max)
                max = woods.get(i);
        }
        int m = 3;
        System.out.println(binarySearch(woods,0,max,m));


        out.flush();
        out.close();
    }
    public static int binarySearch(List<Integer> woods, int l, int r, int m) {
        int max = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (can(woods,m, mid)) {
                max = mid;
                l = mid + 1;

            }else{
                r = mid-1;
            }
        }
        return max;
    }
    private static boolean can(List<Integer> woods, int m, int mid) {
        int r =0;
        for(int i = woods.size()-1;i>=0;i--){
            r+= woods.get(i)/mid;
            if(r>= m)
                return true;
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


