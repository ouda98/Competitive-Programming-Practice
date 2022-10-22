package CP_6_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringDistanceAndTransformProcess_UVa526 {
    static Triple[][] memo;
    static String first;
    static String second;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        boolean f = false;
        while (sc.ready()) {
            first = sc.nextLine();
            if(first.equals("#"))
                break;
            second = sc.nextLine();
            if (f)
                System.out.println();
            f = true;

            int lenOne = first.length();
            int lenTwo = second.length();
            memo = new Triple[lenOne + 1][lenTwo + 1];

            System.out.println(distance(lenOne, lenTwo));

            ArrayList<Print> s = new ArrayList<>();

            while (true) {

                if (lenOne <= 0 && lenTwo <= 0)
                    break;
                else if (lenOne == 0) {
                    s.add(new Print(" Insert ", lenTwo, ","+second.charAt(lenTwo - 1)));
                    lenTwo--;

                } else if (lenTwo == 0) {
                    s.add(new Print(" Delete ", lenOne, ""));
                    lenOne--;
                } else {
                    int px = memo[lenOne][lenTwo].px;
                    int py = memo[lenOne][lenTwo].py;
                    if(px>=0 && py>=0){
                        if (lenOne - px == 1 && lenTwo - py == 1 && memo[lenOne][lenTwo].value != memo[px][py].value) {
                            s.add(new Print(" Replace ", lenOne, ","+ second.charAt(py)));

                        } else if (lenOne == px && lenTwo - py == 1) {
                            s.add(new Print(" Insert ", lenTwo, ","+ second.charAt(py)));
                        } else if (lenOne - px == 1 && lenTwo == py) {
                            s.add(new Print(" Delete ", lenOne, ""));
                        }
                    }
                    lenOne = px;
                    lenTwo = py;

                }

            }
//            for(int i=0;i< memo.length;i++)
//                System.out.println(Arrays.toString(memo[i]));
            int c = 1;
            int deletes = 0;
            int inserts = 0;
            for (int i = s.size() - 1; i >= 0; i--) {
                Print e = s.get(i);

                if (e.op.equals(" Insert "))
                    System.out.println(c+++e.op + e.num + e.letter);
                else
                    System.out.println(c+++e.op + (e.num - deletes + inserts) + e.letter);

                if (e.op.equals(" Delete "))
                    deletes++;
                if (e.op.equals(" Insert "))
                    inserts++;
            }

        }


        out.flush();
        out.close();
    }

    static class Print {
        String op;
        int num;
        String letter;

        public Print(String op, int num, String letter) {
            this.op = op;
            this.num = num;
            this.letter = letter;
        }

    }

    static class Triple {
        int value;
        int px;
        int py;

        public Triple(int value, int px, int py) {
            this.value = value;
            this.px = px;
            this.py = py;
        }

        public String toString() {
            return value + " " + px + " " + py;
        }
    }

    private static int distance(int lenOne, int lenTwo) {

        if (lenOne == 0) {
            memo[lenOne][lenTwo] = new Triple(lenTwo, lenOne, lenTwo - 1);
            return lenTwo;
        }

        if (lenTwo == 0) {
            memo[lenOne][lenTwo] = new Triple(lenOne, lenOne - 1, lenTwo);
            return lenOne;
        }


        if (memo[lenOne][lenTwo] != null)
            return memo[lenOne][lenTwo].value;

        if (first.charAt(lenOne - 1) == second.charAt(lenTwo - 1)) {
            if (memo[lenOne - 1][lenTwo - 1] != null) {
                memo[lenOne][lenTwo] = new Triple(memo[lenOne - 1][lenTwo - 1].value, lenOne - 1, lenTwo - 1);
                return memo[lenOne][lenTwo].value;
            } else {
                memo[lenOne][lenTwo] = new Triple(distance(lenOne - 1, lenTwo - 1), lenOne - 1, lenTwo - 1);
            }
            return memo[lenOne][lenTwo].value;
        } else {
            int r;
            int d;
            int i;
            if (memo[lenOne - 1][lenTwo - 1] != null)
                r = memo[lenOne - 1][lenTwo - 1].value;
            else {
                r = distance(lenOne - 1, lenTwo - 1);
            }

            if (memo[lenOne - 1][lenTwo] != null)
                d = memo[lenOne - 1][lenTwo].value;
            else
                d = distance(lenOne - 1, lenTwo);

            if (memo[lenOne][lenTwo - 1] != null)
                i = memo[lenOne][lenTwo - 1].value;
            else
                i = distance(lenOne, lenTwo - 1);
            int min;
            int minO;
            int minS;
            if (r <= d && r <= i) {
                min = r;
                minO = lenOne - 1;
                minS = lenTwo - 1;
            } else if (d <= r && d <= i) {
                min = d;
                minO = lenOne - 1;
                minS = lenTwo;
            } else {
                min = i;
                minO = lenOne;
                minS = lenTwo - 1;
            }

            memo[lenOne][lenTwo] = new Triple(min + 1, minO, minS);

            return 1 + min;

        }


    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        else if (y <= x && y <= z)
            return y;
        else
            return z;
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



