public class MinDeletionsToObtainStringInRightFormat {
    public static void main(String[] args) {
        String a = "AABBBB";
        int r =minDeletionsToObtainStringInRightFormat(a);
        System.out.println(r);
    }
    public static int minDeletionsToObtainStringInRightFormat(String s) {
        // write your code here
        int ca  =0;
        int cb = 0;
        int r=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                ca++;
                if(cb>r)
                    r++;
            }else{
                cb++;
                if(ca==0)
                    r++;
            }
        }
        return Math.min(ca,Math.min(cb,r));
    }
}
