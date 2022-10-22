package SortingAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {
    static int[] array = {2, 8, 1, 7, 3, 6, 7, 5, 4};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        mergeSort(0, array.length - 1);
        System.out.println(Arrays.toString(array));


        out.flush();
        out.close();
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);

        }
    }

    private static void merge(int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int k = 0;
        int[] arr = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            if (p > mid)
                arr[k++] = array[q++];
            else if (q > end)
                arr[k++] = array[p++];
            else if (array[p] < array[q])
                arr[k++] = array[p++];
            else
                arr[k++] = array[q++];
        }
        for (int i = 0; i < k; i++)
            array[start++] = arr[i];
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



