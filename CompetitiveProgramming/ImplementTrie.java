public class ImplementTrie {
    public static void main(String[] args) {

    }
    public class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
            for(int i=0;i<children.length;i++)
                children[i] = null;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode current = root;
            int index;
            for(int i=0;i<word.length();i++){
                index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                    current.children[index] = new TrieNode();
                current = current.children[index];
            }
            current.endOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            int index;
            for(int i=0;i<word.length();i++){
                index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                    return false;
                current = current.children[index];
            }
            return current.endOfWord == true;

        }

        public boolean startsWith(String word) {
            TrieNode current = root;
            int index;
            for(int i=0;i<word.length();i++){
                index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                    return false;;
                current = current.children[index];
            }
            return true;

        }
    }
}
