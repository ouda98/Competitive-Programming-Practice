public class AddBinary {
    public static void main(String[] args) {

    }
    //Solution2
    public String addBinary2(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int carry = 0;
        for(int i=0;i< Math.max(a.length(),b.length());i++){
            sum += (i>= a.length())?0:a.charAt(i) - '0';
            sum += (i>= b.length())?0:b.charAt(i) - '0';
            sum += carry;
            switch(sum){
                case 3: result.append("1");carry = 1; break;
                case 2: result.append("0");carry = 1; break;
                case 1: result.append("1");carry = 0; break;
                case 0: result.append("0");carry = 0; break;
            }
            sum = 0;
        }
        if(carry == 1)
            result.append("1");
        return result.reverse().toString();
    }
    //Solution 1
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        char ca = '0';
        char cb = '0';
        for(int i=0;i< Math.max(a.length(),b.length());i++){
            if(i>= a.length())
                ca = '0';
            else
                ca = a.charAt(i);

            if(i>= b.length())
                cb = '0';
            else
                cb = b.charAt(i);

            if(ca == '1' && cb == '1'){
                if(carry == 0)
                    result.append("0");
                else{
                    result.append("1");
                }
                carry = 1;
            }
            else if(ca == '1' || cb == '1'){
                if(carry == 0)
                    result.append("1");
                else{
                    result.append("0");
                    carry = 1;
                }
            }else if(ca == '0' && cb == '0'){
                if(carry == 0)
                    result.append("0");
                else{
                    result.append("1");
                    carry = 0;
                }
            }

        }
        if(carry == 1)
            result.append("1");
        return result.reverse().toString();
    }
}
