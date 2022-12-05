import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {

    }
    static ArrayList<ArrayList<Character>> decode;
    static List<String> s;
    public List<String> letterCombinations(String digits) {
        decode = new ArrayList<>();
        s = new ArrayList<>();
        decode.add(new ArrayList<Character>());
        decode.add(new ArrayList<Character>());
        ArrayList<Character> sub = new ArrayList<>();
        sub.add('a');
        sub.add('b');
        sub.add('c');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('d');
        sub.add('e');
        sub.add('f');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('g');
        sub.add('h');
        sub.add('i');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('j');
        sub.add('k');
        sub.add('l');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('m');
        sub.add('n');
        sub.add('o');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('p');
        sub.add('q');
        sub.add('r');
        sub.add('s');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('t');
        sub.add('u');
        sub.add('v');
        decode.add(sub);
        sub = new ArrayList<>();
        sub.add('w');
        sub.add('x');
        sub.add('y');
        sub.add('z');
        decode.add(sub);
        dfs(digits,"");
        return s;
    }
    public void dfs(String digits, String res){
        if(digits.length() == 0){
            if(res.length() == 0)
                return;
            s.add(res);
            return;
        }
        int front = Integer.parseInt(""+digits.charAt(0));
        for(char c : decode.get(front)){
            dfs(digits.substring(1),res+c);
        }
    }

}
