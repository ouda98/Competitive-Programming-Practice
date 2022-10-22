package CP_6_6;

public class IdentifyingStringsLintCode {

    static TrieNode root = new TrieNode();

    public String[] ShortPerfix(String[] stringArray) {
        // write your code here
        root = new TrieNode();
        for (int i = 0; i < stringArray.length; i++)
            insert(stringArray[i]);
        String[] result = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = search(stringArray[i]);
        }

        return result;

    }

    public static class TrieNode {
        TrieNode[] children;
        int counter;

        public TrieNode() {
            counter = 0;
            children = new TrieNode[26];
            for (int i = 0; i < children.length; i++)
                children[i] = null;
        }
    }

    public static void insert(String word) {
        int length = word.length();
        int index;
        TrieNode traverse = root;

        for (int level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (traverse.children[index] == null)
                traverse.children[index] = new TrieNode();
            traverse.children[index].counter += 1;
            traverse = traverse.children[index];

        }
    }

    public static String search(String word) {
        int length = word.length();
        int index;
        TrieNode traverse = root;
        int level;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if (traverse.children[index].counter == 1)
                break;
            traverse = traverse.children[index];
        }
        return (level == length) ? word : word.substring(0, level + 1);
    }

}
