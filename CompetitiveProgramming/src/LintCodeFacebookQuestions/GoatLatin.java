package LintCodeFacebookQuestions;

import java.util.HashSet;

public class GoatLatin {
    public class Solution {
        public String  toGoatLatin(String S) {
            //
            HashSet<Character> set = new HashSet<>();
            set.add('A');
            set.add('a');
            set.add('E');
            set.add('e');
            set.add('I');
            set.add('i');
            set.add('O');
            set.add('o');
            set.add('U');
            set.add('u');
            String[] line = S.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<line.length;i++){
                StringBuilder sub = new StringBuilder();
                String cur = line[i];
                if(set.contains(cur.charAt(0))){
                    sub.append(cur+"ma");
                }else{
                    sub.append(cur.substring(1)+cur.charAt(0)+"ma");
                }
                for(int j=0;j<i+1;j++)
                    sub.append("a");

                sb.append(sub+" ");
            }
            return sb.substring(0,sb.length()-1).toString();
        }
    }
}
