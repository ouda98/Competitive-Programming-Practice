package CP_6_6;

public class ShortEncodingOfWordsLintCode {

    static int counter;
    static TrieNode root;
    public int minimumLengthEncoding(String[] words) {
        counter =0;
        root = new TrieNode();
        for(int i=0;i<words.length; i++)
            insert(words[i]);
        dfs(root,0);
        return counter;
    }
    public void dfs(TrieNode root, int level){
        if(root.children == null) {
            counter+=level+1;
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null)
                dfs(root.children[i], level+1);

        }

    }

    public static class TrieNode{
        TrieNode [] children;
        boolean endOfWord;
        public TrieNode(){
            children = null;
            endOfWord = false;
        }
    }
    public static void insert(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode traverse = root;
        for(level = length-1; level >= 0; level--){
            index = key.charAt(level) - 'a';
            if (traverse.children == null) {
                traverse.children = new TrieNode[26];
            }
            if(traverse.children[index]==null)
                traverse.children[index] = new TrieNode();

            traverse = traverse.children[index];

        }
    }
}