import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(isOpening(s.charAt(i)))
                stack.add(s.charAt(i));
            else{
                if(stack.isEmpty() || !isAMatch(stack.pop(),s.charAt(i)))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isOpening(char a){
        return a == '(' || a == '[' || a == '{';
    }
    public boolean isAMatch(char a, char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
