import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1-(4+5+2)-3)+(6+8)";
        int r = calculate(s);
        System.out.println(r);
    }
    public static int calculate(String s) {
        // Write your code here
        int i = 0;
        int sign = 1;
        int number = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int r = 0;
        while(i<s.length()){
            if(s.charAt(i)==' ') {
                i++;
                continue;
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                number = (s.charAt(i) - '0');
                i++;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    number = number*10 + (s.charAt(i) - '0');
                    i++;
                }
                number*=sign;
                i--;
            }
            else if(s.charAt(i) == '-'){
                r +=number;
                sign =-1;
                number =0;
            }
            else if(s.charAt(i) == '+'){
                r +=number;
                sign =1;
                number =0;
            }
            else if(s.charAt(i) == '('){
                st.push(sign);
                stack.push(r);
                r =0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                r+= number;
                r = r*st.pop();
                stack.push(r);
                r=0;
                number =0;
            }
            i++;


        }
        int e = r+number;
        while(!stack.isEmpty()){
            e+= stack.pop();
        }

        return e;
    }
}
