package CP_6_3;

import java.io.*;
import java.util.*;

public class TheOneHandedTypist_10393 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        ArrayList<Character>[] fingers = new ArrayList[11];
        ArrayList<Character> f = new ArrayList<>();
        f.add('q');
        f.add('a');
        f.add('z');
        fingers[1] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('w');
        f.add('s');
        f.add('x');
        fingers[2] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('e');
        f.add('d');
        f.add('c');
        fingers[3] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('r');
        f.add('f');
        f.add('v');
        f.add('t');
        f.add('g');
        f.add('b');
        fingers[4] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add(' ');
        fingers[5] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add(' ');
        fingers[6] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('y');
        f.add('h');
        f.add('n');
        f.add('u');
        f.add('j');
        f.add('m');
        fingers[7] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('i');
        f.add('k');
        f.add(',');
        fingers[8] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('o');
        f.add('l');
        f.add('.');
        fingers[9] = (ArrayList<Character>) f.clone();
        f.clear();
        f.add('p');
        f.add(';');
        f.add('/');
        fingers[10] = (ArrayList<Character>) f.clone();
        f.clear();
        HashSet<Character> set = new HashSet<>();


        while (sc.ready()) {
            set.clear();
            int fing = sc.nextInt();
            int n = sc.nextInt();
            boolean flag = false;
            int num = 0;
            int[] a = new int[fing];
            for (int i = 0; i < fing; i++)
                a[i] = sc.nextInt();
            int counter = 0;
            HashSet<String> s = new HashSet<>();

            for (int i = 1; i < 11; i++) {
                if (!flag) {
                    if (counter == a.length)
                        num = -1;
                    else
                        num = a[counter++];
                    flag = true;
                }
                if (i != num) {
                    for (int j = 0; j < fingers[i].size(); j++) {
                        set.add(fingers[i].get(j));
                    }
                } else {
                    flag = false;
                }

            }

            String line;
            boolean can;
            int maxLength = 0;
            ArrayList<Pair> write = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                line = sc.nextLine();
                can = true;
                for (int j = 0; j < line.length(); j++) {

                    if (!set.contains(line.charAt(j))) {

                        can = false;
                        break;
                    }
                }
                if (can) {
                    if (maxLength < line.length()) {
                        write.clear();
                        write.add(new Pair(line.length(), line));
                        s.clear();
                        s.add(line);
                        maxLength = line.length();
                    } else if (maxLength == line.length() && !s.contains(line))
                        write.add(new Pair(line.length(), line));
                }
            }
            System.out.println(write.size());
            for (int i = 0; i < write.size(); i++)
                System.out.println(write.get(i).word);
        }


        out.flush();
        out.close();
    }

    public static class Pair {
        int length;
        String word;

        public Pair(int length, String word) {
            this.length = length;
            this.word = word;
        }

        public String toString() {
            return this.word + " " + this.length;
        }

        public int compareTo(Pair o) {
            return this.length - o.length;
        }
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



