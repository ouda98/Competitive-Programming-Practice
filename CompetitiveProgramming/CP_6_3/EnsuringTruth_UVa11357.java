package CP_6_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EnsuringTruth_UVa11357 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int cases = sc.nextInt();
        String find;
        while(cases-->0){

            String[] line = sc.nextLine().split("\\|");
            boolean result = false;
            boolean value;
//            System.out.println(Arrays.toString(line));

            for(int i=0;i<line.length;i++){
                String s = line[i].replaceAll("&","");
                find = "";
                value = true;
                for(int j=1;j<s.length();j++){
                    if(s.charAt(j)!='~' && ((j>0 && s.charAt(j-1)!='~') ||(j==0))){
                        find += "~" + s.charAt(j)+"";
                        value = value & !s.contains(find);
                    }
                    find = "";


                }
                result |= value;
            }
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");

        }


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



