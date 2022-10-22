package Algorithms;

public class Trie {
    public static void main(String[] args) {

    }
    public static class TrieNode {
        boolean endOfWord;
        TrieNode[] children;

        public TrieNode() {
            this.endOfWord = false;
            children = new TrieNode[26];
            for (int i = 0; i < children.length; i++)
                children[i] = null;
        }
    }
        static TrieNode root = new TrieNode();

        public static void insert(String input) {
            TrieNode traverse = root;
            int index;
            for(int i=0;i<input.length();i++){
                index = input.charAt(i) - 'a';
                if(traverse.children[index] == null)
                    traverse.children[index] = new TrieNode();
                traverse = traverse.children[index];
            }
            traverse.endOfWord = true;
        }
    public static boolean search(String input) {
        TrieNode traverse = root;
        int index;
        for(int i=0;i<input.length();i++){
            index = input.charAt(i) - 'a';
            if(traverse.children[index] == null)
                return false;
            traverse = traverse.children[index];
        }
        return traverse.endOfWord;
    }

}
