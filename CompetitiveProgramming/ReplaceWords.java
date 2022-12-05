import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {

    }
    static Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String s : dictionary)
            insert(s);
        String[] array = sentence.trim().replaceAll(" +"," ").split(" ");
        StringBuilder sb = new StringBuilder();
        for(String st : array)
            sb.append(find(st)+" ");
        return sb.toString().substring(0,sb.toString().length()-1);
    }
    public String find(String s){
        Trie current = root;
        int index;
        for(int i=0;i<s.length();i++){
            index = s.charAt(i) - 'a';
            if(current.children[index] == null)
                return s;
            current = current.children[index];
            if(current.endOfWord == true)
                return s.substring(0, i+1);
        }
        return s;
    }

    public void insert(String s){
        Trie current = root;
        int index;
        for(int i=0;i<s.length();i++){
            index = s.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] = new Trie();
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public class Trie{
        Trie[] children;
        boolean endOfWord;
        public Trie(){
            endOfWord = false;
            children = new Trie[26];
        }
    }
}
