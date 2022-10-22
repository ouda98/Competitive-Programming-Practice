import Template.template;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PartitionArrayII625QuickSort {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int [] nums = {4,3,4,1,2,3,1,2};
        int low  = 2;
        int high = 3;
        int l = 0;
        int r = nums.length-1;
        int i =0;
        while(i<=r){
            if(nums[i]<low){
                swap(nums,i++,l++);
            }
            else if(nums[i]>high){
                swap(nums,i,r--);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        out.flush();
        out.close();
    }

    public static void swap(int[] nums, int i,int bound){
        int temp = nums[i];
        nums[i] = nums[bound];
        nums[bound] = temp;
    }

    private static int quickSelect(int[] nums, int low, int l, int r) {
        int m =-1;
        while(l<r) {
            int index = partition(nums, l, r);

            if (nums[index] == low) {
                m = index;
                l=index+1;
            }
            if (nums[index] < low)
                l = index + 1;
            else
                r =index - 1;
        }

        return m;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int locPos = l;
        int temp;
        for(int i=l;i<r;i++){
            if(nums[i]==pivot)
                locPos = i;
            if(nums[i]<pivot){
                temp = nums[i];
                nums[i] = nums[locPos];
                nums[locPos++]= temp;
            }
        }
        temp = nums[r];
        nums[r] = nums[locPos];
        nums[locPos] = temp;
        return locPos;
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
