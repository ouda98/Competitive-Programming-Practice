import java.io.*;
import java.util.StringTokenizer;

public class FindTheSmallestDivisorGivenAThreshold1816BSOnAnswer {

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] nums = new int [5];
        int threshold = 5;
        int answer = binarySearch(nums,0,(int )1e6,threshold);

        out.flush();
        out.close();
    }
    public static int binarySearch(int [] nums , int l, int r, int threshold){
        int max =0;
        while(l<=r){
            int mid = l + (r-l)/2;

            if(can(nums, mid, threshold)){
                max = mid;
                r = mid-1;


            }else
                l = mid+1;
        }
        return max;

    }
    public static boolean can(int[]nums, int mid, int threshold){
        int r =0;
        for(int i=0;i<nums.length;i++){
            r+= Math.ceil(nums[i]/(mid*1.0));
        }
        if(r>threshold)
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



