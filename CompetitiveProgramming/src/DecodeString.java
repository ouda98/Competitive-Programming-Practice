import java.util.HashMap;
import java.util.Stack;

public class DecodeString {
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        String s = "abc3[a]";
        System.out.println(expandExpression(s));
    }


    public static String expandExpression(String s) {
        // write your code here
        if (s.length() == 0) {
            return "";
        }

        Stack<Integer> repeat = new Stack<>();
        Stack<String> tempStr = new Stack<>();
        String res = "";

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + s.charAt(i) - '0';
                    i++;
                }
                repeat.push(count);
            } else if (s.charAt(i) == '[') {
                tempStr.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(tempStr.pop());
                int repeatTime = repeat.pop();

                for (int index = 0; index < repeatTime; index++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
//    static String expandExpression(String s) {
//        Stack<Integer> brackets = new Stack<>();
//        map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '[')
//                brackets.add(i);
//            if (s.charAt(i) == ']') {
//                map.put(brackets.pop(), i);
//            }
//        }
//
//        return expand(s, 0,s.length());
//    }

//    static String expand(String shortExpression, int left,int right) {
//        StringBuilder subResult = new StringBuilder();
//        for (int i = left; i < right; i++) {
//            if (shortExpression.charAt(i) >= '0' && shortExpression.charAt(i) <= '9') {
//                StringBuilder num = new StringBuilder();
//
//                while (shortExpression.charAt(i) >= '0' && shortExpression.charAt(i) <= '9') {
//                    num.append(shortExpression.charAt(i));
//                    i++;
//                }
//                int number = Integer.parseInt(num.toString());
//                int bracketPosition = map.get(i);
//                String expansion = expand(shortExpression, i+1,bracketPosition);
//                i = bracketPosition;
//                while (number-- > 0) {
//                    subResult.append(expansion);
//                }
//
//            } else
//                subResult.append(shortExpression.charAt(i));
//        }
//
//        return subResult.toString();
//
//    }

}

