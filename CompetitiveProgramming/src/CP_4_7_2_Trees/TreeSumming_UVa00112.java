package CP_4_7_2_Trees;

import java.io.*;
import java.util.StringTokenizer;

public class TreeSumming_UVa00112 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner("src/txt.in");
//        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        PrintWriter out = new PrintWriter("src/txt.out");
        while (sc.ready()){
            int open =0;
            int close = 0;
            int target = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while(open==0 || open!=close){
                String line = sc.next();
                StringBuilder n = new StringBuilder();
                for(int i=0;i<line.length();i++){
                    if(line.charAt(i)=='(')
                        open++;
                    else if(line.charAt(i)==')')
                        close++;
                    if(line.charAt(i)!=' ')
                        n.append(line.charAt(i));
                }

                sb.append(n);
            }
            if(sb.length()==2) {
                System.out.println("no");
                continue;
            }

            String[] three = getRootLR(sb.toString());
            Node root = new Node(Integer.parseInt(three[0]));
            Node s = root;
            buildTree(root,three[1],three[2]);
            if(traverse(root,target-root.val))
                System.out.println("yes");
            else
                System.out.println("no");

        }


        out.flush();
        out.close();
    }

    private static boolean traverse(Node root, int target) {
        if(root.left== null && root.right==null && target==0) {
            return true;
        }
        if(root.left== null && root.right==null)
            return false;
        boolean f = false;
        if(root.left!=null)
            f |=traverse(root.left,target-root.left.val);
        if(root.right!=null)
            f |=traverse(root.right,target-root.right.val);

        return f;
    }

    private static void buildTree(Node root, String left, String right) {
        if(!left.equals("()")){
            String [] three = getRootLR(left);
            root.left = new Node(Integer.parseInt(three[0]));
            buildTree(root.left,three[1],three[2]);
        }
        if(!right.equals("()")){
            String [] three = getRootLR(right);
            root.right = new Node(Integer.parseInt(three[0]));
            buildTree(root.right,three[1],three[2]);
        }



    }

    private static String[] getRootLR(String sb) {
        String curr = sb.substring(1,sb.length()-1);
        StringBuilder root = new StringBuilder();
        int i=0;
        for(;i<curr.length();i++){
            if(curr.charAt(i)>='0' && curr.charAt(i)<='9' || curr.charAt(i)=='-')
                root.append(curr.charAt(i));
            else
                break;
        }
        int open =0;
        int close = 0;
        StringBuilder left = new StringBuilder();
        for(;i<curr.length();i++) {
            left.append(curr.charAt(i));
            if (curr.charAt(i) == '(')
                open++;
            if (curr.charAt(i) == ')')
                close++;
            if (open != 0 && open == close)
                break;
        }
        i++;
        return new String[]{root.toString(),left.toString(),curr.substring(i)};

    }

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
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



