package LeetCodeCommonProblems;

public class ImplementTriePrefixTree {
    public static class Trie {
        boolean endOfWord;
        Trie[] children;

        public Trie() {
            // do intialization if necessary
            endOfWord = false;
            children = new Trie[26];
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        static Trie root = new Trie();

        public void insert(String word) {
            // write your code here
            int index;
            Trie traverse = root;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (traverse.children[index] == null)
                    traverse.children[index] = new Trie();
                traverse = traverse.children[index];
            }
            traverse.endOfWord = true;
        }

        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            // write your code here
            int index;
            Trie traverse = root;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (traverse.children[index] == null)
                    return false;
                traverse = traverse.children[index];
            }
            return traverse.endOfWord;
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String word) {
            // write your code here
            int index;
            Trie traverse = root;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (traverse.children[index] == null)
                    return false;
                traverse = traverse.children[index];
            }
            return true;
        }
    }
}
