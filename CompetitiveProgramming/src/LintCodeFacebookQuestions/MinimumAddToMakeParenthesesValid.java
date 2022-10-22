package LintCodeFacebookQuestions;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public class Solution {
        public int minAddToMakeValid(String S) {
            // Write your code here
            Stack<Character> s = new Stack<>();
            int counter = 0;
            for(int i=0;i<S.length();i++){
                if(S.charAt(i) == '(')
                    s.add(S.charAt(i));
                else if(!s.isEmpty())
                    s.pop();
                else
                    counter++;


            }
            return counter + s.size();
        }
    }
}
