package LinkedLists;

import Template.template;

import java.io.*;
import java.util.StringTokenizer;

public class ReverseOperationsFacebook {
    public static void main(String[] args) throws IOException {
        Node head = new Node(1);
        Node tail = head;
        tail.next = new Node(2);;
        tail = tail.next;
        tail.next = new Node(8);;
        tail = tail.next;
        tail.next = new Node(9);
        tail = tail.next;
        tail.next = new Node(12);
        tail = tail.next;
        tail.next = new Node(16);

        Node dummy = new Node(0);
        dummy.next = head;

        Node current = head;
        Node cur = head;
        Node previous = null;
        Node next = null;

        Node current2 = head;
        Node previous2 = null;
        Node next2 = null;

        while(current!=null){
            if(current.data%2==1){
                next = cur.next;
                previous = cur;
                cur = next;
            }else{

            }
            current = current.next;
        }

        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }

    }
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
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