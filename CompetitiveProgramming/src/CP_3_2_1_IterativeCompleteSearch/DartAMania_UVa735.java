package CP_3_2_1_IterativeCompleteSearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DartAMania_UVa735 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        PrintWriter out = new PrintWriter("src/txt.out");
        HashSet<Integer> nums = new HashSet<>();
        nums.add(50);
        for(int i=0;i<=20;i++) {
            nums.add(i);
            if(i>0){
                nums.add(i*2);
                nums.add(i*3);
            }

        }


        while (sc.ready()) {
            int number = sc.nextInt();
            HashSet<String> set = new HashSet<>();
            if(number<=0){
                out.println("END OF OUTPUT");
                break;
            }

            int per = 0;
            int com = 0;
            for (int i: nums)
                for (int j : nums)
                    for (int k : nums) {
                        if(i +j+k==number){
                            per++;
                            String sorted = sort(i,j,k);
                            if(!set.contains(sorted))
                                com++;
                            set.add(sorted);
                        }
                    }
            if(com!=0) {
                out.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", number, com);
                out.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", number, per);
            }else
                out.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n",number);
            out.println("**********************************************************************");
        }



        out.flush();
        out.close();
    }

    private static String sort(int i, int i1, int i2) {
        int [] arr = new int[3];
        arr[0] = i;
        arr[1] = i1;
        arr[2] = i2;
        Arrays.sort(arr);
        return ""+arr[0]+" "+arr[1]+" "+arr[2];
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



