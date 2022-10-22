package LintCodeBacktracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    static List<String> s;
    static HashMap<Character,Character> map;
    public static void main(String[] args) {
        s = new LinkedList<>();
        map = new HashMap<>();
        map.put('a','A');map.put('A','a');
        map.put('b','B');map.put('B','b');
        map.put('c','C');map.put('C','c');
        map.put('d','D');map.put('D','d');
        map.put('e','E');map.put('E','e');
        map.put('f','F');map.put('F','f');
        map.put('g','G');map.put('G','g');
        map.put('h','H');map.put('H','h');
        map.put('i','I');map.put('I','i');
        map.put('j','J');map.put('J','j');
        map.put('k','K');map.put('K','k');
        map.put('l','L');map.put('L','l');
        map.put('m','M');map.put('M','m');
        map.put('n','N');map.put('N','n');
        map.put('o','O');map.put('O','o');
        map.put('p','P');map.put('P','p');
        map.put('q','Q');map.put('Q','q');
        map.put('r','R');map.put('R','r');
        map.put('s','S');map.put('S','s');
        map.put('t','T');map.put('T','t');
        map.put('u','U');map.put('U','u');
        map.put('v','V');map.put('V','v');
        map.put('w','W');map.put('W','w');
        map.put('x','X');map.put('X','x');
        map.put('y','Y');map.put('Y','y');
        map.put('z','Z');map.put('Z','z');

        String b = "a1b2";
        solve(0,b,"");
        System.out.println(s);
    }

    private static void solve(int idx, String in, String out) {
        if(idx== in.length()){
            s.add(out);
            return;
        }
        solve(idx+1, in, out+in.charAt(idx));
        if(map.containsKey(in.charAt(idx)))
            solve(idx+1,in, out + map.get(in.charAt(idx)));
    }

}
