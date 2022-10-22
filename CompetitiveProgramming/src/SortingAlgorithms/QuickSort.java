package SortingAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {
    static int[] array = {2, 8, 1, 7, 3, 6, 7, 5, 4};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        quickSort(0,array.length-1);
        System.out.println(Arrays.toString(array));


        out.flush();
        out.close();
    }

    private static void quickSort(int start, int end) {
        if(start<end){
            int index = partition(start,end, array[(end+start)/2]);
            quickSort(start,index-1);
            quickSort(index, end);
        }
    }

    private static int partition(int left, int right, int pivot) {
        while(left<=right){
            while(array[left]<pivot)
                left++;
            while(array[right]>pivot)
                right--;
            if(left<=right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
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




