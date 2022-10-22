import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReversePairs532MergeSort {

    static int c =0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int[] array = {4,3,2,1};
        mergeSort(array,0, array.length - 1);
        System.out.println(c);
        System.out.println(Arrays.toString(array));


        out.flush();
        out.close();
    }

    private static void mergeSort(int[]array,int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array,start, mid);
            mergeSort(array,mid + 1, end);
            merge(array,start, mid, end);
        }
    }

    private static void merge(int[]array,int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int[] a = new int[end - start + 1];
        int k = 0;
        System.out.println(start+" "+ end+" "+Arrays.toString(array));
        for (int i = start; i <= end; i++) {
            if (p > mid)
                a[k++] = array[q++];
            else if (q > end)
                a[k++] = array[p++];
            else if (array[p] <= array[q]) {
                a[k++] = array[p++];
            }else{
                c+=mid-p+1;
                a[k++] = array[q++];
            }

        }
        for (int i = 0; i < k; i++)
            array[start++] = a[i];
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



