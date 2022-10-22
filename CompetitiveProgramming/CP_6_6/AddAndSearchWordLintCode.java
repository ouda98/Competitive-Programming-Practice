package CP_6_6;

public class AddAndSearchWordLintCode {

    static TrieNode root = new TrieNode();

    public void addWord(String word) {
        // write your code here
        int level;
        int length = word.length();
        int index;
        TrieNode traverse = root;
        for(level =0; level<length;level++){
            index = word.charAt(level) - 'a';
            if(traverse.children == null)
                traverse.children = new TrieNode[26];

            if(traverse.children[index] == null)
                traverse.children[index] = new TrieNode();

            traverse = traverse.children[index];
        }
        traverse.endOfWord = true;
    }

    public boolean search(String word) {
        // write your code here
        return dfs(word,root);
    }
    public static boolean dfs( String word, TrieNode root){

        if(word.length() == 0)
            return root.endOfWord;

        boolean f = false;
        if(word.charAt(0)!='.'){
            int index = word.charAt(0) - 'a';
            if(root.children[index]!= null)
                f|=dfs(word.substring(1), root.children[index]);
        }else {
            for(int i=0;i<26;i++){
                if(root.children[i]!=null){
                    f|=dfs(word.substring(1),root.children[i]);
                }
            }
        }
        return f;
    }

    static class TrieNode{
        TrieNode [] children;
        boolean endOfWord;

        public TrieNode(){
            endOfWord = false;
            children = null;
        }
    }
}
