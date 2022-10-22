import java.util.HashSet;

public class FindLetter {
    public class Solution {
        /**
         * @param str: the str
         * @return: the letter
         */
        public char findLetter(String str) {
            // Write your code here.
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<str.length();i++)
                set.add(str.charAt(i));

            char c = 'Z';
            char l = 'z';
            while(true){

                if(set.contains(c) && set.contains(l))
                    return c;
                if(c=='A' || l=='a')
                    break;
                c = (char)((char)c-1);
                l = (char)((char)l-1);

            }
            return '~';
        }
    }
}
