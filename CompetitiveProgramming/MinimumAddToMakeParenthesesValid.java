public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {

    }
    public int minAddToMakeValid(String s) {
        int left = 0;
        int counter = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                counter++;
            else{
                if(counter>0)
                    counter--;
                else
                    left++;
            }
        }
        return counter + left;
    }
}
