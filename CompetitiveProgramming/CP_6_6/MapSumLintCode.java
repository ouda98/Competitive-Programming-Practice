package CP_6_6;
public class MapSumLintCode {
    MapSumLintCode[] children;;
    int count;
    static final int AlphabetSize = 26;
    boolean endOfWord;
    public MapSumLintCode() {
        // write your code here
        children = new MapSumLintCode[AlphabetSize];
        endOfWord = false;

        count = 0;
        for (int i = 0; i < AlphabetSize; i++)
            children[i] = null;
    }
    static MapSumLintCode root = new MapSumLintCode();

    public void insert(String key, int val) {
        // write your code here
        int level;
        int length = key.length();
        int index;
        MapSumLintCode travers = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (travers.children[index] == null)
                travers.children[index] = new MapSumLintCode();
            travers.children[index].count += val;
            travers = travers.children[index];

        }
        if(travers.endOfWord==true){
            travers = root;
            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                travers.children[index].count = val;
                travers = travers.children[index];

            }
        }
        travers.endOfWord = true;
    }

    public int sum(String prefix) {
        // write your code here
        int level;
        int length = prefix.length();
        int index;
        MapSumLintCode travers = root;
        for (level = 0; level < length; level++) {
            index = prefix.charAt(level) - 'a';
            if (travers.children[index] == null)
                return 0;
            travers = travers.children[index];
        }
        return travers.count;
    }
}