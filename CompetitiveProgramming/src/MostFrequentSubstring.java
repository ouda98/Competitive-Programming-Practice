import java.util.HashMap;

public class MostFrequentSubstring {
    public static void main(String[] args) {
        String s = "abcde";
        int minLength = 2;
        int maxLength = 5;
        int maxUnique = 3;
        int res =getMaxOccurrences(s, minLength, maxLength,maxUnique);
        System.out.println(res);
    }

    public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        // write your code here
        HashMap<String, Integer> subStrings = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = minLength; i <= maxLength; i++) {
        //     map.clear();
        for (int j = 0; j < minLength; j++) {
            if (map.containsKey(s.charAt(j)))
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            else
                map.put(s.charAt(j), 1);
        }
        int left = 0;
        int right = minLength - 1;
        while (left < s.length() && right < s.length()) {
            if (map.size() <= maxUnique) {
                String line = s.substring(left,right+1);
                if (subStrings.containsKey(line))
                    subStrings.put(line, subStrings.get(line) + 1);
                else
                    subStrings.put(line, 1);
            }
            if (map.get(s.charAt(left)) == 1)
                map.remove(s.charAt(left));
            else
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
            right++;
            if(right>=s.length())
                break;
            if (map.containsKey(s.charAt(right)))
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            else
                map.put(s.charAt(right), 1);
            left++;

        }
        // }
        int max =0;
        for(String r: subStrings.keySet())
            max = Math.max(subStrings.get(r),max);
        return max;
    }
}
