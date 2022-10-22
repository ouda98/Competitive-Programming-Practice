package SortingAlgorithms;

import Template.template;

import java.io.*;
import java.util.StringTokenizer;

public class QuickSelect {
    static int [] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int k =2;
        if(k<0 || k>=array.length)
            System.out.println(-1);



        int i = quickSort(0,array.length-1, k);
        System.out.println(array[i]);


        out.flush();
        out.close();
    }

    private static int quickSort(int l, int r, int target) {
            int index = partition(l,r);
            if(index == (array.length-target))
                return index;

            if(index< (array.length-target))
                return quickSort(index+1,r,target);
            else
                return quickSort(l,index-1,target);
    }

    private static int partition(int l, int r) {
        int pivot = array[r];
        int pivLoc = l;
        for(int i=l;i<r;i++){
            if(array[i]<pivot){
                int temp = array[pivLoc];
                array[pivLoc++] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[r];
        array[r] = array[pivLoc];
        array[pivLoc] = temp;

        return pivLoc;
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
