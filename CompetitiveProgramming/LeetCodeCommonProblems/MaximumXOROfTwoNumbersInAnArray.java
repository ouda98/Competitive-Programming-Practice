package LeetCodeCommonProblems;

public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        root = new Trie();
        String[] binary = new String[nums.length];
        String number = "";
        for (int i = 0; i < nums.length; i++) {
            number = Integer.toBinaryString(nums[i]);
            StringBuilder leadingZeros = new StringBuilder();
            int length = number.length();
            while (length++ < 32)
                leadingZeros.append("0");
            number = leadingZeros + number;
            binary[i] = number;
            insert(number);
        }

        int max = 0;
        for (int i = 0; i < binary.length; i++) {
            max = Math.max(max, search(binary[i]));
        }
        return max;
    }

    public int search(String word) {
        Trie traverse = root;
        int index;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - '0';
            if (index == 0 && traverse.children[1] != null) {
                result.append("1");
                traverse = traverse.children[1];
            } else if (index == 1 && traverse.children[0] != null) {
                result.append("1");
                traverse = traverse.children[0];
            } else {
                result.append("0");
                traverse = traverse.children[index];
            }

        }
        return Integer.parseInt(result.toString(), 2);
    }

    public static class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }

    static Trie root;

    public void insert(String word) {
        Trie traverse = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - '0';
            if (traverse.children[index] == null)
                traverse.children[index] = new Trie();
            traverse = traverse.children[index];
        }
    }
}
