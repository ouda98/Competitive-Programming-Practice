public class MultiplyStrings {
    public static void main(String[] args) {
        String s =multiply("123","45");
        System.out.println(s);
    }
    public static String multiply(String num1, String num2) {
        // write your code here
        if(num1.length() == 0 || num2.length() ==0)
            return "0";
        int[] result = new int[num1.length() + num2.length()];
        int index1 = 0;
        for(int i = num1.length()-1;i>=0;i--){
            int n1 = num1.charAt(i) - '0';

            int carry = 0;
            int index2 = 0;
            for(int j= num2.length()-1 ;j>=0;j--){
                int n2 = num2.charAt(j) - '0';

                int sum = n1*n2 + result[index1 + index2] + carry;
                result[index1 + index2] = sum%10;
                carry = sum/10;
                index2++;
            }
            if(carry>0)
                result[index1+index2] = carry;

            index1++;
        }
        int i = result.length-1;
        while(i>=0 && result[i]==0)
            i--;
        if(i==-1)
            return "0";
        StringBuilder sb = new StringBuilder();
        while(i>=0) {
            sb.append(result[i--]);
        }
        return sb.toString();
    }
}
