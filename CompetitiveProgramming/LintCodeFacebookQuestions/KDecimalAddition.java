package LintCodeFacebookQuestions;

public class KDecimalAddition {
    public static void main(String[] args) {
        System.out.println(addition(2,"1","1"));

    }
    public static String addition(int k, String a, String b) {
        // Write your code here
        a = a.replaceFirst ("^0*", "");
        b = b.replaceFirst ("^0*", "");
        if(a.length()==0)
            a = "0";
        if(b.length()==0)
            b = "0";
        if(a.length()>b.length()){
            int diff = a.length() - b.length();
            for(int i=0;i<diff;i++){
                b = "0" + b;
            }
        }else{
            int diff = b.length() - a.length();
            for(int i=0;i<diff;i++){
                a = "0" + a;
            }
        }

        String s = "";
        int carry = 0;
        for(int i=a.length()-1;i>=0;i--){
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';
            if(num1+num2+carry>=k){
                int add = (num1+num2+carry)%k;
                carry = 1;
                s = add+s;
            }else{
                int add = num1+num2+carry;
                carry =0;
                s = add+s;
            }

        }
        if(carry ==1)
            s = carry +s;

        return s;

    }
}
