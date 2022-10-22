package CP_6_6;

public class ImplementTrieLintCode {
    public static class Trie {
        Trie[] children;
        boolean endOfWord;

        public Trie() {
            // do initialization if necessary
            children = new Trie[26];
            endOfWord = false;
        }

        static Trie root = new Trie();

        public void insert(String word) {
            // write your code here
            int length = word.length();
            int index;
            Trie traverse = root;
            for (int level = 0; level < length; level++) {
                index = word.charAt(level) - 'a';
                if (traverse.children[index] == null)
                    traverse.children[index] = new Trie();
                traverse = traverse.children[index];
            }
            traverse.endOfWord = true;
        }

        public boolean search(String word) {
            // write your code here
            int length = word.length();
            int index;
            Trie traverse = root;
            for (int level = 0; level < length; level++) {
                index = word.charAt(level) - 'a';
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
        public boolean startsWith(String prefix) {
            // write your code here
            int length = prefix.length();
            int index;
            Trie traverse = root;
            for (int level = 0; level < length; level++) {
                index = prefix.charAt(level) - 'a';
                if (traverse.children[index] == null)
                    return false;
                traverse = traverse.children[index];
            }
            return true;
        }
    }
}
