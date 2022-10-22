package SortingAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InsertionSort {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] array = {2, 8, 1, 7, 3, 6, 7, 5, 4};
        int temp;
        for(int i=0;i<array.length;i++){
            temp = array[i];
            int j = i;
            while(j>0 && temp<array[j-1]){
                array[j]= array[j-1];
                j--;
            }
            array[j]=temp;
        }
        System.out.println(Arrays.toString(array));

//     ===== ANOTHER VERSION ====== EASIER TO UNDERSTAND
//        for(int i=1;i<array.length;i++){
//            int value = array[i];
//            k = i;
//            for(int j=i-1;j>=0;j--){
//                if(array[j]>value){
//                    array[j+1] = array[j];
//                    k=j;
//                }
//            }
//            array[k] = value;
//        }


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



