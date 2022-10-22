package CP_6_6;

public class Trie {
    final static int AlphabetSize = 26;

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;

        public TrieNode() {
            endOfWord = false;
            for (int i = 0; i < AlphabetSize; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    public static void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode traversal = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (traversal.children[index] == null)
                traversal.children[index] = new TrieNode();

            traversal = traversal.children[index];
        }
        traversal.endOfWord = true;
    }

    public static boolean search(String key) {
        int level;
        int length = key.length();
        TrieNode traversal = root;

        for (level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            if (traversal.children[index] == null)
                return false;
            traversal = traversal.children[index];
        }
        return traversal.endOfWord;
    }


    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}

