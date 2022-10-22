package CP_6_3;

import java.io.*;
import java.util.StringTokenizer;

public class AutomaticCorrectionOfMisspellings_UVa11048 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        int dic = sc.nextInt();
        String[] dictionary = new String[dic];
        for (int i = 0; i < dic; i++)
            dictionary[i] = sc.nextLine();

        int q = sc.nextInt();
        String query;
        boolean oneChangeDone;
        boolean valid;
        String result = "";
        String res = "";
        for (int i = 0; i < q; i++) {
            query = sc.nextLine();
            boolean found = false;
            res = "";

            for (int j = 0; j < dictionary.length; j++) {
                oneChangeDone = false;
                valid = true;

                if (Math.abs(query.length() - dictionary[j].length()) >= 2)
                    continue;
                int r = 0;
                if (query.equals(dictionary[j])) {
                    result = query;
                    found = true;
                    break;
                }
                String longOne;
                String shortOne;
                if (dictionary[j].length() > query.length()) {
                    longOne = dictionary[j];
                    shortOne = query;
                } else {
                    shortOne = dictionary[j];
                    longOne = query;
                }
                for (int k = 0; k < longOne.length(); k++) {
                    if ((shortOne.length() > r && longOne.charAt(k) != shortOne.charAt(r)) || (r >= shortOne.length())) {
                        if (oneChangeDone) {
                            valid = false;
                            break;
                        } else if (k + 1 < longOne.length() && longOne.length()>shortOne.length() && longOne.charAt(k + 1) == shortOne.charAt(r)) {
                            r--;
                        } else if (k + 1 < longOne.length() && r + 1 < shortOne.length() && longOne.charAt(k + 1) == shortOne.charAt(r) &&
                                longOne.charAt(k) == shortOne.charAt(r + 1)) {
                            k += 1;
                            r += 1;
                        } else if (r + 1 < shortOne.length() && k + 1 < longOne.length() && longOne.charAt(k + 1) == shortOne.charAt(r + 1)) {

                        } else if (longOne.charAt(k) != shortOne.charAt(r)){

                        }else{

                            valid = false;
                        }
                        oneChangeDone = true;
                    }
                    r++;


                }
                if (valid == true && res.length() == 0) {
                    res = dictionary[j];
                    found = true;

                }

            }
            if (found) {
                if (query.equals(result))
                    System.out.println(result + " is correct");
                else
                    System.out.println(query + " is a misspelling of " + res);
            } else
                System.out.println(query + " is unknown");


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

