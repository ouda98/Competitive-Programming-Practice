package SortingAlgorithms;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] array = {2, 8, 1, 7, 3, 6, 7, 5,5,5,5, 4};
        int k =0;
        for(int i=0;i<array.length;i++){
            k = Math.max(k,array[i]);
        }

        int [] aux = new int [k+1];
        for(int i=0;i<array.length;i++)
            aux[array[i]]++;
        int j=0;
        for(int i=0;i<aux.length;i++){
            int temp = aux[i];
            while(temp-->0){
                array[j++] = i;
            }
        }
//        System.out.println(Arrays.toString(array));


        out.flush();
        out.close();
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



