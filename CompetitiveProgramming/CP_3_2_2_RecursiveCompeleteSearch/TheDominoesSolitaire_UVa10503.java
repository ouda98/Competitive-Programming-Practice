package CP_3_2_2_RecursiveCompeleteSearch;

import java.io.*;
import java.util.StringTokenizer;

public class TheDominoesSolitaire_UVa10503 {
    static Pair[] pieces;
    static Pair[] game;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()) {
            int spaces = sc.nextInt();
            if (spaces == 0)
                break;
            int n = sc.nextInt();
            game = new Pair[spaces + 2];
            game[0] = new Pair(sc.nextInt(), sc.nextInt(), 0);
            game[game.length - 1] = new Pair(sc.nextInt(), sc.nextInt(), game.length - 1);

            pieces = new Pair[n];
            for (int i = 0; i < n; i++)
                pieces[i] = new Pair(sc.nextInt(), sc.nextInt(), i + game.length);

            if (solve(1))
                System.out.println("YES");
            else
                System.out.println("NO");


        }


        out.flush();
        out.close();
    }
    private static boolean solve(int idx) {
        if (idx == game.length - 1) {
            return true;
        }
        for (int i = 0; i < pieces.length; i++) {
            if (idx < game.length - 2) {
                if (place(idx, game[idx - 1], pieces[i])) {
                    game[idx] = put(game[idx - 1], pieces[i]);
                    if (solve(idx + 1))
                        return true;
                }
            } else {
                if (placeLast(idx,game[idx - 1], pieces[i], game[idx + 1])) {
                    game[idx] = pieces[i];
                    if (solve(idx + 1))
                        return true;
                }
            }
        }
        return false;
    }

    private static Pair put(Pair first, Pair piece) {
        if (first.r == piece.l)
            return new Pair(piece.l, piece.r, piece.pos);
        return new Pair(piece.r, piece.l, piece.pos);
    }


    private static boolean placeLast(int idx,Pair f, Pair s, Pair t) {
        for (int i = 0; i < idx; i++) {
            if (game[i].pos == s.pos)
                return false;
        }
        return (f.r == s.l && s.r == t.l) || (f.r == s.r && s.l == t.l);
    }

    private static boolean place(int idx, Pair first, Pair second) {
        for (int i = 0; i < idx; i++) {
            if (game[i].pos == second.pos)
                return false;
        }
        if (first.r == second.l || first.r == second.r)
            return true;
        return false;
    }

    public static class Pair {
        int l;
        int r;
        int pos;

        public Pair(int l, int r, int pos) {
            this.l = l;
            this.r = r;
            this.pos = pos;
        }

        public String toString() {
            return l + " " + r + " " + pos;
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



