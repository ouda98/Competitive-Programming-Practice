import java.util.ArrayList;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {

    }
    static List<String> result;
    public List<String> removeSubfolders(String[] folder) {
        if(folder.length == 0)
            return new ArrayList<String>();
        root = new Trie();
        for(String s: folder)
            insert(s);
        result = new ArrayList<>();
        dfs(root,"");
        return result;
    }
    static Trie root;
    public void dfs(Trie root, String s){
        if(root.endOfWord == true){
            result.add(s.substring(0,s.length()-1));
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null)
                dfs(root.children[i],s+ (char) (i + '/'));
        }
    }



    public void insert(String s){
        int index;
        Trie current = root;
        s+="/";
        for(int i =0;i<s.length();i++){
            index = s.charAt(i) - '/';
            if(current.children[index] == null)
                current.children[index] = new Trie();
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public class Trie{
        boolean endOfWord;
        Trie[] children;
        public Trie(){
            endOfWord = false;
            children = new Trie[100];
        }
    }
}
